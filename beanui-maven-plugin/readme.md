# BeanUI Maven Plugin
> BeanUI Maven Plugin是完成从Javabean到UI的编译插件，如果需要创建一个BeanUI工程，则需要引入这个插件

详细可参看demo工程的[pom.xml](../demo/pom.xml)

## BeanUI的插件分别绑定了三个maven生命周期：
1. **clean:clean-bean2ui** 删除临时文件夹

```shell
rm -r ${project.path}/vue
rm -r ${project.path}/node
```

1. **validate:pre-bean2ui** VUE编译环境检查和补全

```shell
cp beanui-maven-plugin/vue demo/vue
npm install
```

2. **compile:bean2ui** 生成VUE源代码


3. **package:post-bean2ui** 编译VUE源代码，生成HTML文件

```shell
npm run dev or npm run prod
```

## Plugin demo
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.december</groupId>
            <artifactId>beanui-maven-plugin</artifactId>
            <version>1.0</version>
            <configuration>
                <projectName>BEANUI example</projectName>
                <routerPath>router.yml</routerPath>
                <mode>prd</mode>
                <builders>
                    <builder>
                        <builderClass>org.december.beanui.plus.builder.LoginBuilder</builderClass>
                        <templateClass>demo.view.LoginComponent</templateClass>
                        <templateName>Login.ftl</templateName>
                    </builder>
                </builders>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.december</groupId>
                    <artifactId>spring-beanui</artifactId>
                    <version>1.0</version>
                </dependency>
                <dependency>
                    <groupId>org.december</groupId>
                    <artifactId>beanui-core-plus</artifactId>
                    <version>1.0</version>
                </dependency>
            </dependencies>
            <executions>
                <!-- 清空临时文件夹 -->
                <execution>
                    <id>clean-bean2ui</id>
                    <phase>clean</phase>
                    <goals>
                        <goal>clean-bean2ui</goal>
                    </goals>
                </execution>
                <!-- 拷贝vue目录，并执行npm install -->
                <execution>
                    <id>pre-bean2ui</id>
                    <phase>validate</phase>
                    <goals>
                        <goal>pre-bean2ui</goal>
                    </goals>
                </execution>
                <!-- 生成vue源代码 -->
                <execution>
                    <id>bean2ui</id>
                    <phase>compile</phase>
                    <goals>
                        <goal>bean2ui</goal>
                    </goals>
                </execution>
                <!-- 编写vue源代码，生成html文件 -->
                <execution>
                    <id>post-bean2ui</id>
                    <phase>package</phase>
                    <goals>
                        <goal>post-bean2ui</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## Maven Plugin Parameters
- **routerPath**  左侧菜单配置文件路径，默认会读取工程resource目录下的router.yml, 如果不需要左侧菜单可以不配置
- **workPath**  vue编译工作目录地址，多个工程科共享同一个工作目录，默认将读取工程下的vue目录
- **nodePath**  nodejs的安装目录，默认会从环境变量的PATH中获取nodejs
- **staticPath**  最终生成的HTML文件会输出到target中的static目录，也可自行定义
- **projectName**  项目名称，将会显示到页面顶端以及title标签中
- **mode**  可选参数为dev/prd，如果您还未建立spring boot工程，则可先使用dev模式
- **builders**  自定义扩展builder
    1. builderClass 扩展编译类路径
    2. templateClass  ftl模板类
    3. templateName ftl模板文件