package org.smart4j.framework.helper;

import org.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanHelper {
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> cls : beanClassSet){
            Object obj = ReflectionUtil.getInstance(cls);
            BEAN_MAP.put(cls,obj);
        }
    }

    public static Map<Class<?>, Object> getBeanMap(){
        return BEAN_MAP;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls){
        if (!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class:" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

    public static void setBean(Class<?> cls, Object obj){
        BEAN_MAP.put(cls, obj);
    }
}
