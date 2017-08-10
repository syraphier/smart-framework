package org.smart4j.framework.helper;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropertiesUtil;

import java.util.Properties;

public class ConfigHelper {

    private static final Properties CONFIG_PROPERTIES = PropertiesUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_DIRVER);
    }

    public static String getJdbcUrl(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUser(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_USER);
    }

    public static String getJdbcPassword(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_PASSWORD);
    }

    public static String getAppBasePackage(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_BASE_PACKAGE);
    }

    public static String getAssetPath(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_ASSET_PATH,"/asset/");
    }

    public static String getJspPath(){
        return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }
}
