package org.december.beanui.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.december.beanui.plugin.face.util.ConsoleUtil;
import org.december.beanui.plugin.face.util.FileUtil;

import java.io.File;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Map;

@Mojo(name="post-bean2ui")
public class BeanUIDeployer extends AbstractMojo {
    @Parameter(property = "routerPath")
    private String routerPath;

    @Parameter(property = "staticPath")
    private String staticPath = "static";

    @Parameter(property = "workPath")
    private String workPath = System.getProperty("user.dir") + File.separator + "vue";

    @Parameter(property = "nodePath")
    private String nodePath = System.getProperty("user.dir") + File.separator + "node";

    @Parameter(property = "projectName")
    private String projectName;

    @Parameter(property = "mode")
    private String mode = "dev";

    @Parameter(property = "builders")
    private List<Map> builders;

    @Parameter(defaultValue="${project}", readonly=true, required=true)
    private MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            List runtimeClasspathElements = project.getRuntimeClasspathElements();
            URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
            for (int i = 0; i < runtimeClasspathElements.size(); i++) {
                String element = (String) runtimeClasspathElements.get(i);
                runtimeUrls[i] = new File(element).toURI().toURL();
            }
            ClassLoader classLoader = new URLClassLoader(runtimeUrls, Thread.currentThread().getContextClassLoader());
            if("dev".equals(mode)) {
                Socket socket = null;
                try {
                    socket = new Socket("localhost", 9527);
                } catch (Exception e) {
                    getLog().info("\"" +  workPath +  "\" " + nodePath + File.separator + "npm run dev");
                    ConsoleUtil.exec(nodePath + File.separator + "npm run dev", workPath);
                } finally {
                    socket.close();
                }
            }
            if("prd".equals(mode)) {
                getLog().info("\"" +  workPath +  "\" " + nodePath + File.separator + "npm run build:prod");
                ConsoleUtil.exec(nodePath + File.separator + "npm run build:prod",  workPath);
                String oldPath = new File(workPath + File.separator + "dist").getPath();
                String newPath = classLoader.getResource("").getPath() + File.separator + staticPath;
                FileUtil.copyDir(oldPath, newPath);
            }
        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
    }
}
