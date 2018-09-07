package org.december.beanui.plugin.builder;

import freemarker.template.Template;
import org.december.beanui.element.annotation.I18N;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.util.ClassUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class I18NBuilder extends Builder {
    public I18NBuilder(String name, ClassLoader classLoader, String distPath) {
        super(name, classLoader, distPath);
    }

    @Override
    public Map run(Template template) throws BuilderException {
        Map results = new HashMap();
        Set<Class> classes = ClassUtil.getClasses(super.getClassLoader());
        for(Class clazz:classes) {
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields) {
                field.setAccessible(true);
                I18N i18n = field.getAnnotation(I18N.class);
                if(i18n != null) {
                    Map map = ClassUtil.annotation2map(i18n);
                    Iterator iterator = map.keySet().iterator();
                    while(iterator.hasNext()) {
                        String key = (String)iterator.next();
                        String value = (String)map.get(key);
                        if(results.containsKey(key)) {
                            Map formMap = (Map)results.get(key);
                            if(formMap.containsKey(clazz.getName())) {
                                Map valueMap = (Map)formMap.get(clazz.getName());
                                valueMap.put(field.getName(), value);
                            } else {
                                Map valueMap = new HashMap();
                                valueMap.put(field.getName(), value);
                                formMap.put(clazz.getName(), valueMap);
                            }
                        } else {
                            Map formMap = new HashMap();
                            Map valueMap = new HashMap();
                            valueMap.put(field.getName(), value);
                            formMap.put(clazz.getName(), valueMap);
                            results.put(key, formMap);
                        }
                    }
                }
            }
        }
        return results;
    }
}
