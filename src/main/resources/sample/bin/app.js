var vertx     = require('vertx');
var container = require('vertx/container');
var config = container.config;

container.deployModule("com.kafeblog.vertx~module-manager~0.1", config);
