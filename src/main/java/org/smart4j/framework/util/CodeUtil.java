package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

public final class CodeUtil {
    private static final Logger logger = LoggerFactory.getLogger(CodeUtil.class);

    public static String encodeURL(String source){
        String target;
        try{
            target = URLEncoder.encode(source,"UTF-8");
        } catch (Exception e){
            logger.error("encode url error",e);
            throw new RuntimeException(e);
        }

        return target;
    }

    public static String decodeURL(String source){
        String target;
        try{
            target = URLDecoder.decode(source,"UTF-8");
        } catch (Exception e){
            logger.error("decode url error",e);
            throw new RuntimeException(e);
        }

        return target;
    }
}
