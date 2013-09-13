package com.kafeblog.vertx;

/*
 * Copyright 2013 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * @author <a href="http://kafeblog.com">Khoi Nguyen</a>
 */

import org.vertx.java.core.AsyncResult;
import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Verticle;

import static com.kafeblog.vertx.helper.ModuleLoaderHelper.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModuleLoaderVerticle extends Verticle {
  private final Map<String, String> deployments = new HashMap<String, String>();
  
  public void start() {
    final JsonObject config = container.config();
    final Logger log = container.logger();
    
    Set<String> fieldNames = config.getFieldNames();
    log.info("Starting ModuleLoaderVerticle");
    
    for (String fieldName : fieldNames) {
      if (isModuleConfig(fieldName)) {
        final String moduleName = parseModuleNameFromConfigField(fieldName);
        
        JsonObject moduleCfg = config.getObject(fieldName);
        
        container.deployModule(moduleName, moduleCfg, new Handler<AsyncResult<String>>() {
          @Override
          public void handle(AsyncResult<String> result) {
            if (result.succeeded()) {
              deployments.put(moduleName, result.result());
              log.info("Module " + moduleName + " successfully deployed with id: " + result.result());
            } else {
              log.warn("Deploy module failed", result.cause());;
            }
          }
        });
      }
    }
  }

}
