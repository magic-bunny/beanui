package org.december.beanui.plugin.builder;

import org.december.beanui.plugin.face.Builder;
import org.december.beanui.plugin.face.exception.BuilderException;
import org.december.beanui.plugin.face.util.PluginSystem;

import java.util.HashMap;
import java.util.Map;

public class ProjectNameBuilder extends Builder {
    @Override
    public Map run() throws BuilderException {
        Map result = new HashMap();
        result.put("projectName", PluginSystem.getProperty("projectName"));
        return result;
    }
}
