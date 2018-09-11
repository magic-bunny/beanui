package org.december.beanui.plugin.tool.util;

import java.util.Properties;

public class PluginSystem {
    private static Properties properties = new Properties();

    public static void setPropertie(String key, String value) {
        if(key != null && value != null) {
            properties.setProperty(key, value);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
