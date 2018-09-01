package org.december.beanui.spring;

import org.december.beanui.bean.Event;
import org.december.beanui.tool.RestReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ControllerReader implements RestReader {
    public void scan(Set<Class> classes) {
        Map<String, Event> results = new HashMap<String, Event>();
        for(Class clazz:classes) {
            RestController restController = (RestController)clazz.getAnnotation(RestController.class);
            if(restController != null) {
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    RequestMethod[] requestMethods = requestMapping.method();
                    for (RequestMethod requestMethod : requestMethods) {
                        Event event = new Event();
                        event.setPath(requestMapping.path().length>0?requestMapping.path()[0]:requestMapping.value()[0]);
                        if(requestMethod == RequestMethod.GET) {
                            event.setMethod("get");
                            Class returnType = method.getReturnType();
                            results.put(returnType.getName(), event);
                        } else if(requestMethod == RequestMethod.POST) {
                            event.setMethod("post");
                            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                            Class[] parameterTypes = method.getParameterTypes();
                            for(int i=0;i<parameterAnnotations.length;i++) {
                                Annotation[]oneParameterAnnotations = parameterAnnotations[i];
                                for(Annotation parameterAnnotation : oneParameterAnnotations) {
                                    if(parameterAnnotation.annotationType() == ResponseBody.class) {
                                        Class parameterType = parameterTypes[i];
                                        results.put(parameterType.getName(), event);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


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
