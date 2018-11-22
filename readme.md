# Angry BeanUI
> 一款通过Javabean来开发WEB UI的框架

以下一些场景是否会出现在您的工作当中：
- 我是一名Java开发人员，并不精通Web技术，但今天被安排开发一个简单的页面；
- 一个为期两个月的Java后台服务（后台为主）项目，由于团队无人精通前端，故花费了一个月做页面；
- 前年做了一个图书管理系统，去年做了一个采购管理系统，今年做了一个用户管理系统；
- 我是一个名Java开发人员，实在没有兴趣参与Web开发；

## 目前究竟流行什么Web UI框架？
以上提到的是我经常遇到的困惑，在如今前后端分离的大潮当中，Java也几乎放弃了Web UI框架的投入，就算身为Java开发人员，我们也很少使用Struts、JSF等Java UI框架来开发，JSP也很少写了。
但在一个Javaer的日常中，就算一百个不愿意，还是会遇到UI的需求，但打开搜索引擎时，满满的都是层出不穷的新技术。也许就连身在其中的人也很难说清楚什么是目前流行的Web框架。

## 前后端分离
说到前后端分离，这也是我常常思考的场景，如果简单把我们开发的具备UI的系统分为两类：
- 外部系统（如门户网站、博客等）
- 内部系统（如管理系统等）

那么外部系统往往都有专业的UI工作人员甚至是UI团队来负责，而内部系统则不一定了，那么这时候前端开发的任务便落到了后端工程师的身上。

这种情况下，前后端分离就变得不那么美了，这意味着：
- 学习前端各种框架（Jquery、ReactJS、VUE、Angular）
- 学习前端的测试手段（unit、mock）
- 学习前端编译、打包
- 其实还有很多的理论还有概念需要了解
- 总之前端的知识量绝对不亚于后端，甚至超过后端学习的难度

最后在你恶补知识后花了大力气做出了前端页面，可能依然被喷。

## Javaer理想中的内部UI开发过程
- 不需要了解前端的各种知识
- 在开发完后端代码（如Restful service）后仅需要简单配置即可将页面呈现

我们的内部系统往往不需要绚丽的效果、复杂的动画、高度订制的结构，他可能仅仅是后台服务的一个入口，或者管理一些配置，又或者是管理一些简单的数据对象（如用户、订单、商品之类的），也可能是呈现一些常见的二维报表。他们最多的操作仅仅是对数据对象的CRUD。
故此，我想到了是否能够通过Java反向生成前端代码，在此之前已经有GWT等框架这么做过了，但代码入侵性过强。

## 关于BeanUI的特点
- **纯配置式** 完全采用Java注解来进行UI描述
- **无侵入式代码** UI描述将不会对后端Restful service项目造成影响
- **快速开发**
- **具备一定程度的UI订制能力**

![example](example.png)

## Dependencies
1. 需要安装npm：install [nodejs 10.0.0](https://nodejs.org) or [npm 6.2.0](https://www.npmjs.com/);
2. 需要安装[apache maven](http://maven.apache.org);

## 安装BeanUI
1. `git clone https://github.com/magic-bunny/beanui`
2. `cd beanui`
3. `mvn install`

## 安装和运行BeanUI example
1. 将`beanui/vue`目录拷贝到任意目录`%your_vue_path%`
2. `cd %your_vue_path%` and `npm install`
3. `cd beanui/demo` and `mvn install`
4. `java -jar demo-1.0.jar`
5. 打开浏览器，输入`http://localhost:8080`

## 在DEV模式下运行BeanUI examle
1. 将 [pom.xml](demo/pom.xml)文件的运行模式修改为dev ` <mode>dev</mode>`
2. `cd beanui/demo`
3. `mvn install`

## 程序入口
开始构建一个BeanUI工程需要建立一个[router.yml](demo/src/resources/router.yml)
> 注意：[router.yml](demo/src/resources/router.yml)不是必须的，如果不配置，框架会扫描所有包含`@Component`的注解类并进行转换，此时需要配置`path`属性，若不配置则为`/`

> 如果需要一个最简单的BeanUI项目，可参看[single-demo](single-demo)

### 单页面router实例
```yml
path: /test
component: demo.view.layout.card.CardComponent
```

### 带左侧菜单router
```yml
name: root
children:
  - title: home
    icon: star
    component: demo.view.layout.card.CardComponent
```

### 带登录页面以及菜单router
```yml
path: /login
component: demo.view.LoginComponent
children:
  - title: home
    icon: star
    component: demo.view.layout.card.CardComponent
```

## Javabean注解说明
需要了解各个控件在Javabean当中的写法，请[点击](beanui-core/readme.md)
> 注意：由于使用了Element UI（[饿了么](http://element-cn.eleme.io/#/zh-CN/component/button)），因此几乎可以完全参看Element UI的组件说明

## BeanUI Maven插件说明
需要了解Maven插件的用法，请[点击](beanui-maven-plugin/readme.md)

需要了解加强库的用法，请[点击](beanui-core-plus/readme.md)


## License
BeanUI is licensed under the MIT license. See LICENSE for further details.