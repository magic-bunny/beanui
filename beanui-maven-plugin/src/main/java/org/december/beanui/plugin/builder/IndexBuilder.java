package org.december.beanui.plugin.builder;

import freemarker.template.Template;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.util.PluginSystem;

import java.util.HashMap;
import java.util.Map;

public class IndexBuilder extends Builder {
    public IndexBuilder(String name, ClassLoader classLoader, String distPath) {
        super(name, classLoader, distPath);
    }

    @Override
    public Map run(Template template) throws BuilderException {
        Map result = new HashMap();
        result.put("projectName", PluginSystem.getProperty("projectName"));
        return result;
    }
}
