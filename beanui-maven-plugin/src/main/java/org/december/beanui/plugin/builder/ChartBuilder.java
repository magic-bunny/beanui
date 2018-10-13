package org.december.beanui.plugin.builder;

import org.december.beanui.chart.Config;
import org.december.beanui.plugin.face.Builder;
import org.december.beanui.plugin.face.exception.BuilderException;
import org.december.beanui.plugin.face.exception.SpringReaderException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

public class ChartBuilder extends Builder {
    public Map run() throws BuilderException, SpringReaderException {
        final Map result = new HashMap();
        Class chartClass = this.getTemplateClass();
        Annotation[] annotations = chartClass.getAnnotations();
        for (Annotation annotation:annotations) {
            biuldOption(annotation, result);
        }

        Field[] fields = chartClass.getDeclaredFields();
        Field.setAccessible(fields, true);
        for(Field field:fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();
            for(Annotation fieldAnnotation:fieldAnnotations) {
                biuldOption(field.getName(), fieldAnnotation, result);
            }
        }
        return new HashMap() {{
            put("options", result);
        }};
    }

    private void biuldOption(Annotation annotation, Map result) {
        biuldOption(null, annotation, result);
    }

    private void biuldOption(String id, Annotation annotation, Map result) {
        Map content = annotation2map(annotation);
        String defaultKey = (String)content.get(Config.DEFAULT_PROPERTY);
        content.remove(Config.DEFAULT_PROPERTY);
        if(defaultKey != null && id != null) {
            content.put(defaultKey, "data." + id);
        } else {
            content.remove(defaultKey);
        }
        String tag = ((String)content.get("tag"));
        content.remove("tag");
        if("series".equals(tag)) {
            if(result.containsKey(tag)) {
                List list = (List)result.get(tag);
                list.add(content);
            } else {
                List list = new ArrayList();
                list.add(content);
                result.put(tag, list);
            }
        } else {
            result.put(tag, content);
        }
    }

    private Map annotation2map(Annotation annotation) {
        try {
            Map results = new HashMap();
            String property = "memberValues";
            InvocationHandler invo = Proxy.getInvocationHandler(annotation);
            Field field = invo.getClass().getDeclaredField(property);
            field.setAccessible(true);
            Map map = (Map)field.get(invo);
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                String value = (String)map.get(key);
                if("".equals(value)) {
                    continue;
                }
                if(Config.DEFAULT_PROPERTY.equals(value)) {
                    results.put(Config.DEFAULT_PROPERTY, key);
                }
                if(value.startsWith("$")) {
                    value = value.substring(1);
                    if(!value.contains(".")) {
                        value = "data." + value;
                    }
                    results.put(key, value);
                    continue;
                }
                if((value.startsWith("[") && value.endsWith("]")) || (value.startsWith("{") && value.endsWith("}"))) {
                    results.put(key, value);
                    continue;
                }

                if("tag".equals(key)) {
                    results.put(key, value);
                    continue;
                }

                results.put(key, "'" + value + "'");
            }
            return results;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
