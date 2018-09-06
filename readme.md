# BeanUI
![logo](logo.icon)

## Description
A JAVA Web framework based on Javabean

## Dependencies
1. install [nodejs](https://nodejs.org) or [npm](https://www.npmjs.com/);
2. install [apache maven](http://maven.apache.org);

## Getting Started
1. `git clone https://github.com/magic-bunny/beanui`
2. `cd beanui/demo/vue`;
3. `npm install`;
4. `cd beanui/beanui-core`
5. `mvn install`
6. `cd beanui/beanui-maven-plugin-tool`
7. `mvn install`
8. `cd beanui/spring-beanui`
9. `mvn install`
10. `cd beanui/beanui-maven-plugini`
11. `mvn install`
12. `cd beanui/demo`
13. `mvn install`
14. `java -jar demo-[version].jar`

## Maven Plugin Parameters
- **routerPath**  menu config file(yaml) path
- **workPath**  html template file path, now based on element ui
- **staticPath**  dist to Java WEB-INF/static
- **projectName**  web project title

## License
GPPT is licensed under the MIT license. See LICENSE for further details.