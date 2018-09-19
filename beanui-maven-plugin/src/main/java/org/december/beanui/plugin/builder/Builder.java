package org.december.beanui.plugin.builder;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.exception.SpringReaderException;
import org.december.beanui.plugin.util.Path;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

public abstract class Builder {
    public static String TEMPLATE_DIR = "/ftl";

    private ClassLoader classLoader;

    private String templateName;

    private Class templateClass;

    private String distPath;

    private Map data;

    public void create() {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(this.getClass(), TEMPLATE_DIR);
        configuration.setDefaultEncoding("utf-8");
        try {
            Template template = configuration.getTemplate(templateName);
            data = run(template);
            if(distPath != null && !"".equals(distPath)) {
                buildData(data, Path.e(distPath), template);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BuilderException e) {
            e.printStackTrace();
        } catch (SpringReaderException e) {
            e.printStackTrace();
        }
    }

    private void buildData(Map data, String distPath, Template template) {
        if(distPath.contains("*")) {
            Map map = data;
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                Object value = map.get(key);
                outputFile(template, value, distPath.replace("*", key));
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

    public abstract Map run(Template template) throws BuilderException, SpringReaderException;

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

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getDistPath() {
        return distPath;
    }

    public void setDistPath(String distPath) {
        this.distPath = distPath;
    }

    public Class getTemplateClass() {
        return templateClass;
    }

    public void setTemplateClass(Class templateClass) {
        this.templateClass = templateClass;
    }
}
