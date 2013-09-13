package com.kafeblog.vertx.helper;

public class ModuleLoaderHelper {
  public static final String PREFIX = "module:";
  public static String parseModuleNameFromConfigField(String configField) {
	  String moduleName = configField.substring(PREFIX.length());
	  
	  return moduleName;
  }
  
  public static boolean isModuleConfig(String configField) {
	  return configField.startsWith(PREFIX);
  }
}
