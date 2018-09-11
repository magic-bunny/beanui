export default FreeMarker template error (DEBUG mode; use RETHROW in production!):
For "${...}" content: Expected a string or something automatically convertible to string (number, date or boolean), but this has evaluated to a sequence (ArrayList wrapped into f.t.DefaultListAdapter):
==> datas  [in template "I18N.ftl" at line 1, column 18]

----
FTL stack trace ("~" means nesting-related):
	- Failed at: ${datas}  [in template "I18N.ftl" at line 1, column 16]
----

Java stack trace (for programmers):
----
freemarker.core.NonStringException: [... Exception message was already printed; see it above ...]
	at freemarker.core.EvalUtil.coerceModelToString(EvalUtil.java:390)
	at freemarker.core.Expression.evalAndCoerceToString(Expression.java:82)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:41)
	at freemarker.core.Environment.visit(Environment.java:324)
	at freemarker.core.MixedContent.accept(MixedContent.java:54)
	at freemarker.core.Environment.visit(Environment.java:324)
	at freemarker.core.Environment.process(Environment.java:302)
	at freemarker.template.Template.process(Template.java:325)
	at org.december.beanui.plugin.builder.Builder.outputFile(Builder.java:66)
	at org.december.beanui.plugin.builder.Builder.buildData(Builder.java:55)
	at org.december.beanui.plugin.builder.Builder.create(Builder.java:38)
	at org.december.beanui.plugin.Bean2UIMojo.execute(Bean2UIMojo.java:76)
	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
	at org.codehaus.classworlds.Launcher.main(Launcher.java:47)
