package org.december.beanui.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.december.beanui.plugin.bean.Router;
import org.december.beanui.plugin.builder.*;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.util.FileUtil;
import org.december.beanui.plugin.util.PluginSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Map;

@Mojo(name="bean2ui", requiresDependencyResolution = ResolutionScope.TEST)
public class Bean2UIMojo extends AbstractMojo {

    @Parameter(property = "routerPath")
    private String routerPath;

    @Parameter(property = "staticPath")
    private String staticPath = "static";

    @Parameter(property = "workPath")
    private String workPath = System.getProperty("user.dir") + File.separator + "vue";

    @Parameter(property = "projectName")
    private String projectName;

    @Parameter(property = "mode")
    private String mode = "dev";

    @Parameter(property = "builders")
    private List<Map> builders;

    @Parameter(defaultValue="${project}", readonly=true, required=true)
    private MavenProject project;

    public void execute() {
        try {
            PluginSystem.setPropertie("routerPath", routerPath);
            PluginSystem.setPropertie("workPath", workPath);
            PluginSystem.setPropertie("staticPath", staticPath);
            PluginSystem.setPropertie("projectName", projectName==null?project.getName():projectName);

            List runtimeClasspathElements = project.getRuntimeClasspathElements();
            URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
            for (int i = 0; i < runtimeClasspathElements.size(); i++) {
                String element = (String) runtimeClasspathElements.get(i);
                runtimeUrls[i] = new File(element).toURI().toURL();
            }
            ClassLoader classLoader = new URLClassLoader(runtimeUrls, Thread.currentThread().getContextClassLoader());

            FileUtil.deleteDir( "${workPath}/index.html");
            FileUtil.deleteDir( "${workPath}/src/router");
            FileUtil.deleteDir( "${workPath}/src/views/beanui");
            String routerDistPath = "${workPath}/src/router/index.js";
            String indexDistPath = "${workPath}/index.html";
            String i18nDistPath = "${workPath}/src/lang/*.js";
            String i18nIndexDistPath = "${workPath}/src/lang/index.js";
            String langSelectDistPath = "${workPath}/src/components/LangSelect/Logo.ftl";

            ProjectNameBuilder indexBuilder = new ProjectNameBuilder();
            indexBuilder.setTemplateName("Index.ftl");
            indexBuilder.setClassLoader(classLoader);
            indexBuilder.setDistPath(indexDistPath);
            indexBuilder.create();

            RouterBuilder routerBuilder = new RouterBuilder();
            routerBuilder.setTemplateName("Router.ftl");
            routerBuilder.setClassLoader(classLoader);
            routerBuilder.setDistPath(routerDistPath);
            routerBuilder.create();

            List<Router> routers = routerBuilder.getRouter().getChildren();
            for(Router router:routers) {
                routerBuilder.search(classLoader, router);
            }
            LangBuilder langBuilder = new LangBuilder();
            langBuilder.setTemplateName("Lang.ftl");
            langBuilder.setClassLoader(classLoader);
            langBuilder.setDistPath(i18nDistPath);
            langBuilder.create();

            LangIndexBuilder langIndexBuilder = new LangIndexBuilder();
            langIndexBuilder.setTemplateName("LangIndex.ftl");
            langIndexBuilder.setClassLoader(classLoader);
            langIndexBuilder.setDistPath(i18nIndexDistPath);
            langIndexBuilder.create();

            LangIndexBuilder langSelectBuilder = new LangIndexBuilder();
            langSelectBuilder.setTemplateName("LangSelect.ftl");
            langSelectBuilder.setClassLoader(classLoader);
            langSelectBuilder.setDistPath(langSelectDistPath);
            langSelectBuilder.create();

            this.execBuilder(classLoader);

            String os = System.getProperty("os.name");
            boolean isWin = false;
            if(os.toLowerCase().startsWith("win")){
                isWin = true;
            }
            if("dev".equals(mode)) {
                Socket socket = null;
                try {
                    socket = new Socket("localhost", 9527);
                } catch (Exception e) {
                    execDist(isWin?"cmd /c start npm run dev":"npm run dev");
                } finally {
                    socket.close();
                }
            }
            if("prd".equals(mode)) {
                execDist(isWin?"cmd /c npm run build:prod":"npm run build:prod");
                String oldPath = new File(workPath + File.separator + "dist").getPath();
                String newPath = classLoader.getResource("").getPath() + File.separator + staticPath;
                FileUtil.copyDir(oldPath, newPath);
            }
        } catch (Exception e) {
            getLog().error(e.getMessage());
            e.printStackTrace();
        }
    }

    private void execBuilder(ClassLoader classLoader) throws BuilderException {
        for(Map map:builders) {
            String templateClass = (String)map.get("templateClass");
            String builderClass = (String)map.get("builderClass");
            String templateName = (String)map.get("templateName");
            String distPath = (String)map.get("distPath");
            if(builderClass == null || "".equals(builderClass)) {
                throw new BuilderException("No builder class can be found");
            }
            try {
                Class clazz = Class.forName(builderClass);
                Builder builder = (Builder)clazz.newInstance();//classLoader.loadClass()
                builder.setClassLoader(classLoader);
                builder.setDistPath(distPath);
                builder.setTemplateName(templateName);
                if(templateClass != null && !"".equals(templateClass)) {
                    builder.setTemplateClass(classLoader.loadClass(templateClass));
                }
                builder.create();
            } catch (InstantiationException e) {
                throw new BuilderException(e);
            } catch (IllegalAccessException e) {
                throw new BuilderException(e);
            } catch (ClassNotFoundException e) {
                throw new BuilderException(e);
            }
        }
    }

    private void execDist(String shell) {
        BufferedReader input = null;
        try {
            Process process = Runtime.getRuntime().exec(shell, null, new File(workPath));
            input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                getLog().info(line);
            }
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}