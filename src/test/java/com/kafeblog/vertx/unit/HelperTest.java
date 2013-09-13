package com.kafeblog.vertx.unit;

import static com.kafeblog.vertx.helper.ModuleLoaderHelper.*;

import org.junit.Assert;
import org.junit.Test;

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
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class HelperTest {

  @Test
  public void testConfigFieldIsModuleName() {
    String field = "module:com.kafeblog.vertx~module-manager~1.0";
    boolean isModuleName = isModuleConfig(field);
    
    Assert.assertTrue(isModuleName);
  }
  
  @Test
  public void testConfigFieldIsNotModuleName() {
    String field = "com.kafeblog.vertx~module-manager~1.0";
    boolean isModuleName = isModuleConfig(field);
    
    Assert.assertFalse(isModuleName);
  }
  
  @Test
  public void testParseModuleNameFromValidField() {
    String field = "module:com.kafeblog.vertx~module-manager~1.0";
    String moduleName = parseModuleNameFromConfigField(field);
    
    Assert.assertEquals("Module name must parse correctly", "com.kafeblog.vertx~module-manager~1.0", moduleName);
  }
}
