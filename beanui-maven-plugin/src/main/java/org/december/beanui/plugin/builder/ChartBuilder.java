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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChartBuilder extends Builder {
    public Map run() throws BuilderException, SpringReaderException {
        final Map result = new HashMap();
        Class chartClass = this.getTemplateClass();
        Annotation[] annotations = chartClass.getAnnotations();
        for(Annotation annotation:annotations) {
            String packageName = annotation.annotationType().getPackage().getName();
            if(LineChart.class.getPackage().getName().equals(packageName)) {
                Field[] fields = chartClass.getFields();
                for(Field field:fields) {
                    Annotation[] fieldAnnotations = field.getAnnotations();
                    if(fieldAnnotations.length > 0) {
                        Map content = annotation2map(fieldAnnotations[0]);
                        Object data = content.get("data");
                        if(data != null) {
                            content.put("data", "this.chartData." + field.getName());
                        }
                        result.put(fieldAnnotations[0].annotationType().getSimpleName(), content);
                    }
                }
                return new HashMap() {{
                  put("options", result);
                }};
            }
        }
        throw new BuilderException(chartClass.getName() + " is not a Chart");
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
                if(!"data".equals(key)) {
                    results.put(key, "'" + object + "'");
                }
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
