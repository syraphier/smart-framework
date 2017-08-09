package org.smart4j.framework.helper;

import org.smart4j.framework.ConfigConstant;

import java.util.Properties;

public class ConfigHelper {

    private static final Properties CONFIG_PROPERTIES = PropertiesUtil.loadProps(ConfigConstant.CONFIG_FILE);

    private static String getJdbcDriver(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_DIRVER);
    }

    private static String getJdbcUrl(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_URL);
    }

    private static String getJdbcUser(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_USER);
    }

    private static String getJdbcPassword(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_PASSWORD);
    }

    private static String getAppBasePackage(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_BASE_PACKAGE);
    }

    private static String getAssetPath(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_ASSET_PATH,"/asset/");
    }

    private static String getJspPath(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }
}
