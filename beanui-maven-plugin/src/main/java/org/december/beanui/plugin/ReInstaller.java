package org.december.beanui.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.december.beanui.plugin.face.util.ConsoleUtil;
import org.december.beanui.plugin.face.util.FileUtil;
import org.december.beanui.plugin.face.util.Platform;

import java.io.File;
import java.util.List;
import java.util.Map;

@Mojo(name="clean-bean2ui")
public class ReInstaller extends AbstractMojo {
    @Parameter(property = "routerPath")
    private String routerPath;

    @Parameter(property = "staticPath")
    private String staticPath = "static";

    @Parameter(property = "workPath")
    private String workPath = System.getProperty("user.dir") + File.separator + "vue";

    @Parameter(property = "nodePath")
    private String nodePath = Platform.isWin()?System.getProperty("user.dir") + File.separator + "node":"";

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
            new File(workPath).delete();
            new File(nodePath).delete();
        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
    }
}
