> 这是对core包的一个扩展工程，包含了一些登录、权限等处理

详细可参看demo工程的[pom.xml](../demo/pom.xml)

## Plugin demo

需要在maven plugin的builder节点下添加关于登录的builder class
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