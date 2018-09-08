package org.december.beanui.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.december.beanui.plugin.bean.Router;
import org.december.beanui.plugin.builder.I18NIndexBuilder;
import org.december.beanui.plugin.builder.IndexBuilder;
import org.december.beanui.plugin.builder.I18NBuilder;
import org.december.beanui.plugin.builder.RouterBuilder;
import org.december.beanui.plugin.util.FileUtil;
import org.december.beanui.plugin.util.PluginSystem;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
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

            FileUtil.deleteDir( workPath + File.separator + "index.html");
            FileUtil.deleteDir( workPath + File.separator + "src" + File.separator + "router");
            FileUtil.deleteDir( workPath + File.separator + "src" + File.separator + "views" + File.separator + "beanui");
            String routerDistPath = workPath + File.separator + "src" + File.separator + "router" + File.separator + "index.js";
            String indexDistPath = workPath + File.separator + "index.html";
            IndexBuilder baseBuilder = new IndexBuilder("index.ftl", classLoader, indexDistPath);
            RouterBuilder routerBuilder = new RouterBuilder("Router.ftl", classLoader, routerDistPath);

            List<Router> routers = routerBuilder.getRouter().getChildren();
            for(Router router:routers) {
                routerBuilder.search(classLoader, router);
            }
            String i18nDistPath = PluginSystem.getProperty("workPath") + File.separator + "src" + File.separator + "lang" + File.separator + "*.js";
            new I18NBuilder("I18N.ftl", classLoader, i18nDistPath);

            String i18nIndexDistPath = PluginSystem.getProperty("workPath") + File.separator + "src" + File.separator + "lang" + File.separator + "index.js";
            new I18NIndexBuilder("I18NIndex.ftl", classLoader, i18nIndexDistPath);

            String langSelectDistPath = PluginSystem.getProperty("workPath") + File.separator + "src" + File.separator + "components" + File.separator + "LangSelect" + File.separator + "index.vue";
            new I18NIndexBuilder("LangSelect.ftl", classLoader, langSelectDistPath);

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