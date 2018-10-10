package org.december.beanui.plugin.builder;

import org.december.beanui.chart.annotation.LineChart;
import org.december.beanui.plugin.face.Builder;
import org.december.beanui.plugin.face.exception.BuilderException;
import org.december.beanui.plugin.face.exception.SpringReaderException;
import org.december.beanui.plugin.face.util.ClassUtil;

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
                Object data = content.get("data");
                if(data != null) {
                    content.put("data", "this.chartData." + field.getName());
                }
                if(fieldAnnotation.annotationType().getName().endsWith("Series")) {
                    String name = fieldAnnotation.annotationType().getSimpleName();
                    if(result.containsKey(name)) {
                        List list = (List)result.get(name);
                        list.add(content);
                    } else {
                        List list = new ArrayList();
                        list.add(content);
                        result.put(name, list);
                    }
                } else {
                    result.put(fieldAnnotation.annotationType().getSimpleName(), content);
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
                Object object = map.get(key);
                if(object instanceof String) {
                    String value = (String)object;
                    if(value.startsWith(":") || value.startsWith("$")) {
                        key = ":" + key;
                        value = value.substring(1);
                    }
                    results.put(key.replaceAll("_", "-"), value);
                } else {
                    results.put(key.replaceAll("_", "-"), object);
                }
                if(!"data".equals(key)) {
                    results.put(key, "'" + object + "'");
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
