package org.december.beanui.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.december.beanui.plugin.bean.Router;
import org.december.beanui.plugin.builder.I18NBuilder;
import org.december.beanui.plugin.builder.I18NIndexBuilder;
import org.december.beanui.plugin.builder.ProjectNameBuilder;
import org.december.beanui.plugin.builder.RouterBuilder;
import org.december.beanui.plugin.tool.util.FileUtil;
import org.december.beanui.plugin.tool.util.PluginSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

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

            ProjectNameBuilder indexBuilder = new ProjectNameBuilder("Index.ftl", classLoader, indexDistPath);
            indexBuilder.create();

            RouterBuilder routerBuilder = new RouterBuilder("Router.ftl", classLoader, routerDistPath);
            routerBuilder.create();

            List<Router> routers = routerBuilder.getRouter().getChildren();
            for(Router router:routers) {
                routerBuilder.search(classLoader, router);
            }
            I18NBuilder i18NBuilder = new I18NBuilder("I18N.ftl", classLoader, i18nDistPath);
            i18NBuilder.create();

            I18NIndexBuilder i18NIndexBuilder = new I18NIndexBuilder("I18NIndex.ftl", classLoader, i18nIndexDistPath);
            i18NIndexBuilder.create();

            I18NIndexBuilder langSelectBuilder = new I18NIndexBuilder("LangSelect.ftl", classLoader, langSelectDistPath);
            langSelectBuilder.create();

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