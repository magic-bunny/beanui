> BeanUI Maven Plugin是完成从Javabean到UI的编译插件，如果需要创建一个BeanUI工程，则需要引入这个插件

详细可参看demo工程的[pom.xml](../demo/pom.xml)

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
                <execution>
                    <phase>compile</phase>
                    <goals>
                        <goal>bean2ui</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## Maven Plugin Parameters
- **routerPath**  menu config file(yaml) path
- **workPath**  html template file path, now based on element ui
- **staticPath**  dist to Java WEB-INF/static
- **projectName**  web project title
- **mode**  可选参数为dev/prd，如果您还未建立spring boot工程，则可先使用dev模式
- **builders**  自定义扩展builder