package org.december.beanui.plugin.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Template;
import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.util.ClassUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LangBuilder extends Builder {
    @Override
    public Map run(Template template) throws BuilderException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map tree = new HashMap();
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
                        if(!"".equals(value)) {
                            Map lastTree = buildTree(key+".datas."+clazz.getName(), tree);
                            lastTree.put(field.getName(), value);
                        }
                    }
                }
            }
        }

        try {
            Iterator iterator = tree.keySet().iterator();
            while(iterator.hasNext()) {
                String key = (String)iterator.next();
                Map value = (Map)tree.get(key);
                value.put("datas", objectMapper.writeValueAsString(value.get("datas")));
                results.put(key, value);
            }
        } catch (JsonProcessingException e) {
            throw new BuilderException(e);
        }

        return results;
    }

    private Map buildTree(String className, Map tree) {
        String[] pkgs = className.split("\\.");
        Map lastTree = tree;
        for(String pkg:pkgs) {
            if(!lastTree.containsKey(pkg)) {
                lastTree.put(pkg, new HashMap());
            }
            lastTree = (Map)lastTree.get(pkg);

        }
        return lastTree;
    }
}
