package org.december.beanui.plugin.builder;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.december.beanui.plugin.exception.BuilderException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Builder {
    private ClassLoader classLoader;

    private Map data;

    public Builder(String name, ClassLoader classLoader, String distPath) {
        this.classLoader = classLoader;
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
        configuration.setDefaultEncoding("utf-8");
        try {
            Template template = configuration.getTemplate(name);
            data = run(template);
            if(distPath != null && !"".equals(distPath))
                buildData(data, distPath, template);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BuilderException e) {
            e.printStackTrace();
        }
    }

    public Builder(String name, List<Class> classes, ClassLoader classLoader, String distPath) {
        this.classLoader = classLoader;
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
        configuration.setDefaultEncoding("utf-8");
        try {
            Template template = configuration.getTemplate(name);
            data = run(template, classes);
            if(distPath != null && !"".equals(distPath))
                buildData(data, distPath, template);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BuilderException e) {
            e.printStackTrace();
        }
    }

    public Builder(String name, Class clazz, ClassLoader classLoader, String distPath) {
        this.classLoader = classLoader;
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
        configuration.setDefaultEncoding("utf-8");
        try {
            Template template = configuration.getTemplate(name);
            data = run(template, clazz);
            if(distPath != null && !"".equals(distPath))
                buildData(data, distPath, template);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BuilderException e) {
            e.printStackTrace();
        }
    }

    private void buildData(Map data, String distPath, Template template) {
        if(distPath.contains("*")) {
            Map map = data;
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                Object value = iterator.next();
                Map datas = new HashMap();
                datas.put("datas", value);
                outputFile(template, datas, distPath.replace("*", key));
            }
        } else {
            outputFile(template, data, distPath);
        }
    }

    private void outputFile(Template template, Object data, String distPath) {
        Writer out = null;
        try {
            out = new FileWriter(new File(distPath));
            template.process(data, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map run(Template template) throws BuilderException {
        return null;
    }

    public Map run(Template template, Class clazz) throws BuilderException {
        return null;
    }

    public Map run(Template template, List<Class> classes) throws BuilderException {
        return null;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
