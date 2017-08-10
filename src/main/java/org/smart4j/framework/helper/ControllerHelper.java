package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();

        for (Class<?> controllerClass : controllerClassSet){
            Method[] methods = controllerClass.getMethods();
            if (ArrayUtil.isNotEmpty(methods)){
                for (Method method : methods){
                    if (method.isAnnotationPresent(Action.class)){
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        if (mapping.matches("\\w+:/\\w*")){
                            String[] array = mapping.split(":");
                            if (ArrayUtil.isNotEmpty(array) && array.length == 2){
                                String requestMethod = array[0];
                                String requestPath = array[1];
                                Request request = new Request(requestMethod,requestPath);
                                Handler handler = new Handler(controllerClass, method);
                                ACTION_MAP.put(request,handler);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath){
        return ACTION_MAP.get(new Request(requestMethod,requestPath));
    }
}
