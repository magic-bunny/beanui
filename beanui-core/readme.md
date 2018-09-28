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
- [Alert](#Alert) 警告
- [Autocomplete](#Autocomplete) 自动补齐输入框
- [Badge](#Badge) 标记
- [Breadcrumb](#Breadcrumb) 面包屑
- [Button](#Button) 按钮
- [Card](#Card) 卡片
- [Carousel](#Carousel) 走马灯
- [Cascader](#Cascader) 级联选择器
- [Checkbox](#Checkbox) 多选框
- [CheckboxButton](#CheckboxButton) 多选按钮
- [CheckboxButtonGroup](#CheckboxButtonGroup) 多选按钮组
- [CheckboxGroup](#CheckboxGroup) 多选组
- [Collapse](#Collapse) 折叠面板
- [ColorPicker](#ColorPicker) 颜色选择器
- [Component](#Component) 组件
- [DatePicker](#DatePicker) 日期选择器
- [Dialog](#Dialog) 弹出层
- [Dropdown](#Dropdown) 下拉菜单
- [Element](#Element) Dom元素
- [Form](#Form) 表单
- [FormItem](#FormItem) 表单元素
- [IgnoreData](#IgnoreData) 忽略渲染
- [Input](#Input) 输入框
- [InputNumber](#InputNumber) 数字选择器
- [Loading](#Loading) 加载
- [MessageBox](#MessageBox) 消息框
- [NavMenu](#NavMenu) 导航菜单
- [Notification](#Notification) 通知
- [Pagination](#Pagination) 分页
- [Popover](#Popover) 弹出框
- [Progress](#Progress) 进度条
- [Radio](#Radio) 单选框
- [RadioButton](#RadioButton) 单选按钮
- [RadioButtonGroup](#RadioButtonGroup) 单选按钮组
- [RadioGroup](#RadioGroup) 单选组
- [Rate](#Rate) 评分
- [Select](#Select) 选择器
- [Slider](#Slider) 滑块
- [Steps](#Steps) 步凑条
- [Subplot](#Subplot) 分栏布局
- [Switch](#Switch) 开关
- [Table](#Table) 表格
- [TableColum](#TableColum) 表格列
- [Tabs](#Tabs) 标签页
- [Tag](#Tag) 标签
- [TimePicker](#TimePicker) 时间选择器
- [Tooltip](#Tooltip) 文字提示
- [Transfer](#Transfer) 穿梭框
- [Tree](#Tree) 树
- [Upload](#Upload) 上传
- [I18N](#I18N) 国际化

alert
---
```java
@Alert
private String alert;
```

autocomplete
---
```java
@Autocomplete
private String autocomplete;
```

badge
---
```java
@Badge
@Input
private String input;
```

breadcrumb
---
```java
@Breadcrumb
private String Breadcrumb;
```

button
---
```java
@Button(text = "save")
private String button;
```

card
---
```java
@Card(title = "title")
private MyForm myForm;
```

carousel
---
```java
@Carousel(data = {"$myForm1", "$myForm2"})
private String carousel;
private MyForm myForm1;
private MyForm myForm2;
```

cascader
---
```java
@Cascader
private String cascader;
```

checkbox
---
```java
@Checkbox
private String checkbox;
```

checkboxButton
---
```java
@CheckboxButton
private String checkboxButton;
```

checkboxButtonGroup
---
```java
@CheckboxButtonGroup(data = "$checkboxButtonGroupData")
private String checkboxButtonGroup;
private List<Map> checkboxButtonGroupData
```

checkboxGroup
---
```java
@CheckboxGroup(data = "checkboxGroupData")
private String checkboxGroup;
private List<Map> checkboxGroupData
```

collapse
---
```java
@Collapse
private String Collapse;
```

colorPicker
---
```java
@ColorPicker
private String colorPicker;
```

component
---
```java
@Component
public class MyComponent {

}
```

datePicker
---
```java
@DatePicker
private Date datePicker;
```

dialog
---
```java
@Component
public class MyComponent {
    @Dialog(title = "MyDialog")
    private MyForm myForm;
}
```

dropdown
---
```java
@Dropdown(data = "$dropdownData")
private String dropdown;
private List<Map> dropdownData;
```

element
---
订制标签元素，以下代码相当于在页面建立了一个div标签
```java
@Element(tag = "div")
private String element;
```

form
---
```java
@Form
public class MyForm {

}
```

formItem
在Form中使用，默认可以不写，一般当使用表单规则校验，以及需要将元素定位在同一行中才使用
---
```java
@FormItem(prop = "g1")
private String input1;
@FormItem(prop = "g1")
private String input2;
```

ignoreData
添加该标签后，这个属性将不会渲染到页面上
---
```java
@IgnoreData
private String ignoreData;
```

input
---
```java
@Input
private String input;
```

inputNumber
---
```java
@InputNumber
private String inputNumber;
```

loading
---
```java
@Loading
@Input
private String input;
```

messagebox
---


navmenu
---

notification
---

pagination
---

popover
---

progress
---

radio
---

radioButton
---

radioButtonGroup
---

radioGroup
---

rate
---

select
---

slider
---

steps
---

subplot
---

switch
---

table
---

tableColum
---

tabs
---

tag
---

timePicker
---

tooltip
---

transfer
---

tree
---

upload
---

i18n
---
支持多国语言切换，只需要在属性上加入i18n注解即可
```java
@I18N(en = "username", zh_CN = "用户名")
@Input
private String input;
```