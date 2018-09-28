## 控件结构
[router.yml](../demo/src/main/resources/router.yml)是整个UI描述的入口：
- title: 菜单标题
- path: 菜单URL，需要斜杠开头
- component: 类全称
- roles: 权限
- icon： 菜单图标

其中component标识的便是一个菜单的入口页面，也是我们一个UI功能的基本单元，任何component类的需要加上component注解
```java
@Component
public class MyComponent {
    private MyForm myForm;

    get()...
    set()...
}
```
在component中所包含的属性必须是一个Form，你需要在Form类中加上Form注解：
```java
@Form
public class MyForm {
    ...
}
```
另外在component中的属性可以有以下几种修饰注解：
- Card
- Dialog
- Carousel
```java
@Component
public class MyComponent {
    //myForm将以一个弹出层的形式展现
    @Dialog
    private MyForm myForm;

    get()...
    set()...
}
```
Form类就是我们Restful service对应的request body和response body了
```java
@Form
public class MyForm {
    @Input
    private String username;
    @Input
    private String password;
}
```

> 注意1： 一定要符合Javabean的规范，生成相应的get、set方法

> 注意2： Form中的属性类型可以任意指定，并不一定非得是String

## 控件列表
- [Alert](#alert) 警告
- [Autocomplete](#autocomplete) 自动补齐输入框
- [Badge](#badge) 标记
- [Breadcrumb](#breadcrumb) 面包屑
- [Button](#button) 按钮
- [Card](#card) 卡片
- [Carousel](#carousel) 走马灯
- [Cascader](#cascader) 级联选择器
- [Checkbox](#checkbox) 多选框
- [CheckboxButton](#checkboxbutton) 多选按钮
- [CheckboxButtonGroup](#checkboxbuttongroup) 多选按钮组
- [CheckboxGroup](#checkboxGroup) 多选组
- [Collapse](#collapse) 折叠面板
- [ColorPicker](#colorPicker) 颜色选择器
- [Component](#component) 组件
- [DatePicker](#datePicker) 日期选择器
- [Dialog](#dialog) 弹出层
- [Dropdown](#dropdown) 下拉菜单
- [Element](#element) Dom元素
- [Form](#form) 表单
- [FormItem](#formItem) 表单元素
- [IgnoreData](#ignoredata) 忽略渲染
- [Input](#input) 输入框
- [InputNumber](#inputnumber) 数字选择器
- [Loading](#loading) 加载
- [MessageBox](#messagebox) 消息框
- [NavMenu](#navmenu) 导航菜单
- [Notification](#notification) 通知
- [Pagination](#pagination) 分页
- [Popover](#popover) 弹出框
- [Progress](#progress) 进度条
- [Radio](#radio) 单选框
- [RadioButton](#radioButton) 单选按钮
- [RadioButtonGroup](#radiobuttongroup) 单选按钮组
- [RadioGroup](#radiogroup) 单选组
- [Rate](#rate) 评分
- [Select](#select) 选择器
- [Slider](#slider) 滑块
- [Steps](#steps) 步凑条
- [Subplot](#subplot) 分栏布局
- [Switch](#switch) 开关
- [Table](#table) 表格
- [TableColum](#tablecolum) 表格列
- [Tabs](#tabs) 标签页
- [Tag](#tag) 标签
- [TimePicker](#timePicker) 时间选择器
- [Tooltip](#tooltip) 文字提示
- [Transfer](#transfer) 穿梭框
- [Tree](#tree) 树
- [Upload](#upload) 上传
- [I18N](#i18n) 国际化

Alert
---
```java
@Alert
private String alert;
```

Autocomplete
---
```java
@Autocomplete
private String autocomplete;
```

Badge
---
```java
@Badge
@Input
private String input;
```

Breadcrumb
---
```java
@Breadcrumb
private String Breadcrumb;
```

Button
---
```java
@Button(text = "save")
private String button;
```

Card
---
```java
@Card(title = "title")
private MyForm myForm;
```

Carousel
---
```java
@Carousel(data = {"$myForm1", "$myForm2"})
private String carousel;
private MyForm myForm1;
private MyForm myForm2;
```

Cascader
---
```java
@Cascader
private String cascader;
```

Checkbox
---
```java
@Checkbox
private String checkbox;
```

CheckboxButton
---
```java
@CheckboxButton
private String checkboxButton;
```

CheckboxButtonGroup
---
```java
@CheckboxButtonGroup(data = "$checkboxButtonGroupData")
private String checkboxButtonGroup;
private List<Map> checkboxButtonGroupData
```

CheckboxGroup
---
```java
@CheckboxGroup(data = "checkboxGroupData")
private String checkboxGroup;
private List<Map> checkboxGroupData
```

Collapse
---
```java
@Collapse
private String Collapse;
```

ColorPicker
---
```java
@ColorPicker
private String colorPicker;
```

Component
---
```java
@Component
public class MyComponent {

}
```

DatePicker
---
```java
@DatePicker
private Date datePicker;
```

Dialog
---
```java
@Component
public class MyComponent {
    @Dialog(title = "MyDialog")
    private MyForm myForm;
}
```

Dropdown
---
```java
@Dropdown(data = "$dropdownData")
private String dropdown;
private List<Map> dropdownData;
```

Element
---
```java
//订制标签元素，以下代码相当于在页面建立了一个div标签
@Element(tag = "div")
private String element;
```

Form
---
```java
@Form
public class MyForm {

}
```

FormItem
---
```java
//在Form中使用，默认可以不写，一般当使用表单规则校验，以及需要将元素定位在同一行中才使用
@FormItem(prop = "g1")
private String input1;
@FormItem(prop = "g1")
private String input2;
```

IgnoreData
---
```java
//添加该标签后，这个属性将不会渲染到页面上
@IgnoreData
private String ignoreData;
```

Input
---
```java
@Input
private String input;
```

InputNumber
---
```java
@InputNumber
private String inputNumber;
```

Loading
---
```java
@Loading
@Input
private String input;
```

Messagebox
---


Navmenu
---

Notification
---

Pagination
---

Popover
---

Progress
---

Radio
---

RadioButton
---

RadioButtonGroup
---

RadioGroup
---

Rate
---

Select
---

Slider
---

Steps
---

Subplot
---

Switch
---

Table
---

TableColum
---

Tabs
---

Tag
---

TimePicker
---

Tooltip
---

Transfer
---

Tree
---

Upload
---

I18N
---
```java
//支持多国语言切换，只需要在属性上加入i18n注解即可
@I18N(en = "username", zh_CN = "用户名")
@Input
private String input;
```