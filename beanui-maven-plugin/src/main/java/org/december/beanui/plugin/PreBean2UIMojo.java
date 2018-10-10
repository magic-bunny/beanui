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
import java.util.List;
import java.util.Map;

@Mojo(name="pre-bean2ui")
public class PreBean2UIMojo extends AbstractMojo {
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
            if(!new File(workPath).exists()) {
                getLog().info("Copy vue work path to your project path: " + System.getProperty("user.dir"));
                String[] filters = {"node_modules", "dist"};
                FileUtil.loadRecourseFromJarByFolder("/vue/", System.getProperty("user.dir"), PreBean2UIMojo.class, filters);
                getLog().info("Copy vue is finished");
            }
            if(!new File(nodePath).exists()) {
                getLog().info("Copy npm work path to your project path: " + System.getProperty("user.dir"));
                FileUtil.loadRecourseFromJarByFolder("/node/", System.getProperty("user.dir"), PreBean2UIMojo.class);
                getLog().info("Copy npm is finished");
            }
            if(new File(workPath).exists()) {
                getLog().info("\"" +  workPath +  "\" " + nodePath + File.separator + "npm install");
                ConsoleUtil.exec(nodePath + File.separator + "npm install", workPath);
            }
        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
    }
}
