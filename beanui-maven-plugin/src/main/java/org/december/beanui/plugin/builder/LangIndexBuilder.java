package org.december.beanui.plugin.builder;

import freemarker.template.Template;
import org.december.beanui.plugin.face.exception.BuilderException;

import java.util.*;

public class LangIndexBuilder extends LangBuilder {
    @Override
    public Map run(Template template) throws BuilderException {
        Map data = super.run(template);
        Map results = new HashMap();
        List list = new ArrayList();
        Iterator iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            list.add(key);
        }
        results.put("langs", list);
        return results;
    }
}
