package org.december.beanui.spring;
import org.december.beanui.plugin.tool.RestReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ControllerReader implements RestReader {
    public Map<String, String> readResourceSetting(Class clazz, String func) {
        Map<String, String> result = new HashMap<String, String>();
        try {
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method:methods) {
                if(func.equals(method.getName())) {
                    Annotation[] annotations = method.getAnnotations();
                    for(Annotation annotation:annotations) {
                        if(annotation.annotationType() == RequestMapping.class) {
                            Map map = annotation2map(annotation);
                            String[] paths = (String[])map.get("path");
                            String[] values = (String[])map.get("value");
                            RequestMethod[] ms = (RequestMethod[])map.get("method");
                            String m = "get";
                            if(ms[0] == RequestMethod.GET) {
                                m = "get";
                            } else if(ms[0] == RequestMethod.POST) {
                                m = "post";
                            }
                            result.put("path", paths.length>0?paths[0]:values[0]);
                            result.put("method", m);
                            return result;
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Map annotation2map(Annotation annotation) throws IllegalAccessException, NoSuchFieldException {
        String property = "memberValues";
        InvocationHandler invo = Proxy.getInvocationHandler(annotation);
        Field field = invo.getClass().getDeclaredField(property);
        field.setAccessible(true);
        return (Map)field.get(invo);
    }
}
