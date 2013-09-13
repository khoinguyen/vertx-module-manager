# Vert.x Module Manager Project

This module to put in place the conventions to auto-deploy the modules

## How it works

Follow the below convention for the configuration file

    {
      "manager": {
         "notify_address": "<address for notification once any event on modules>"
      },
      "module:io.vertx~mod-mongo-persistor~2.1.0-SNAPSHOT" : {
         "address": "mongo.persistor",
         "db_name": "mymongodb",
         "host": "localhost",
         "port": 27017,
         "fake": false
      },
      "module:io.vertx~mod-work-queue~2.0.0-final": {
         "address": "workqueue",
         "process_timeout": 10,
         "persistor_address": "mongo.persistor",
         "collection": "work_items"  
      },
      "module:io.vertx~mod-auth-mgr~2.0.0-final": {
         "address": "com.auth",
         "user_collection": "user_access",
         "persistor_address": "mongo.persistor",
         "session_timeout": 10   
      }
    }
    
The above configuration shall deploy `mod-mongo-persistor`, `mod-work-queue` and `mod-auth-mgr`, once deploy it will notify to the address configured.

For the main verticle, just deploy this module with `container.config`.

## Sample script for Javascript application

I have a structure for simple application with single main verticle, you can just edit the `config.json` file to assemble new application easily.