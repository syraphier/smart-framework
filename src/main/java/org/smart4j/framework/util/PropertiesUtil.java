package org.smart4j.framework.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null){
                throw new FileNotFoundException(fileName + " is not found");
            }
            properties = new Properties();
            properties.load(is);
        } catch (IOException ioe){
            logger.error("load file error", ioe);
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e){
                    logger.error("close input stream error", e);
                }
            }
        }

        return properties;
    }

    /**
     * 返回String类型Value
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties properties,String key, String defaultValue){
        String value = defaultValue;
        if (properties.contains(key)){
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 返回String类型Value,默认为空
     * @param properties
     * @param key
     * @return
     */
    public static String getString(Properties properties, String key){
        return getString(properties,key,"");
    }


    /**
     * 获取boolean类型Value
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Properties properties, String key, Boolean defaultValue){
        boolean booleanValue = defaultValue;

        if (properties.containsKey(key)){
            booleanValue = CastUtil.castBoolean(properties.getProperty(key));
        }

        return booleanValue;
    }

    /**
     * 获取boolean类型Value，默认为false
     * @param properties
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties properties, String key){
        return getBoolean(properties,key,false);
    }
}
