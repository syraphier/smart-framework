package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CastUtil {

    private static final Logger logger = LoggerFactory.getLogger(CastUtil.class);

    public static String castString(Object obj,String defaultString){
        return obj != null ? String.valueOf(obj) : defaultString;
    }

    public static String castString(Object obj){
        return castString(obj,"");
    }

    public static double castDouble(Object obj, double defaultDouble){
        double doubleValue = defaultDouble;
        if (obj != null){
            String s = castString(obj);
            if (StringUtils.isNoneEmpty(s)){
                try {
                    doubleValue = Double.valueOf(s);
                } catch (NumberFormatException e){
                    logger.error("cast double error", e);
                }
            }
        }
        return doubleValue;
    }

    public static double castDouble(Object obj){
        return castDouble(obj,0);
    }

    public static long castLong(Object obj, long defaultLong){
        long longValue = defaultLong;
        if (obj != null){
            String s = castString(obj);
            if (StringUtils.isNotEmpty(s)){
                try {
                    longValue = Long.valueOf(s);
                } catch (NumberFormatException e){
                    logger.error("cast long error",e);
                }
            }
        }

        return longValue;
    }

    public static long castLong(Object obj){
        return castLong(obj,0);
    }

    public static boolean castBoolean(Object obj, boolean defaultBoolean){
        boolean booleanValue = defaultBoolean;
        if (obj != null) {
            String s = castString(obj);
            if (StringUtils.isNotEmpty(s)) {
                try {
                    booleanValue = Boolean.valueOf(s);
                } catch (Exception e) {
                    logger.error("cast boolean error", e);
                }
            }
        }

        return booleanValue;
    }

    public static boolean castBoolean(Object obj){
        return castBoolean(obj,false);
    }

}
