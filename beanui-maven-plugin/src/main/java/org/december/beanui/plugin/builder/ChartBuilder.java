package org.december.beanui.plugin.builder;

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
        Field[] fields = chartClass.getDeclaredFields();
        Field.setAccessible(fields, true);
        for(Field field:fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();
            for(Annotation fieldAnnotation:fieldAnnotations) {
                Map content = annotation2map(fieldAnnotation);
                String value = (String)content.get("data");
                if(value != null && "''".equals(value)) {
                    content.put("data", "data." + field.getName());
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
        }
        return new HashMap() {{
            put("options", result);
        }};
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
                if((value.startsWith("[") && value.endsWith("]")) || (value.startsWith("{") && value.endsWith("}"))) {
                    results.put(key, value);
                } else {
                    if("tag".equals(key)) {
                        results.put(key, value);
                    } else {
                        results.put(key, "'" + value + "'");
                    }
                }
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
