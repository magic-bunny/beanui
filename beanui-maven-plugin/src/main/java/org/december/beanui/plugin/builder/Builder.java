package org.december.beanui.plugin.builder;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.december.beanui.plugin.exception.BuilderException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Builder {
    private ClassLoader classLoader;

    public Builder(String name, ClassLoader classLoader, String distPath) {
        this(name, null, classLoader, distPath);
    }

    public Builder(String name, Class clazz, ClassLoader classLoader, String distPath) {
        this.classLoader = classLoader;
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
        configuration.setDefaultEncoding("utf-8");
        Writer out = null;
        try {
            Template template = configuration.getTemplate(name);
            Object data;
            if(clazz == null) {
                data = run(template);
            } else {
                data = run(template, clazz);
            }
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

    public Object run(Template template) throws BuilderException {
        return null;
    }

    public Object run(Template template, Class clazz) throws BuilderException {
        return null;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
