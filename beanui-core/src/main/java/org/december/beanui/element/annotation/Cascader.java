package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Cascader {
    String options() default "";//	可选项数据源，键名可通过 props 属性配置	array	—	—
    String props() default "";//	配置选项，具体见下表	object	—	—
    String value() default "";//	选中项绑定值	array	—	—
    String separator() default "";//	选项分隔符	string	—	斜杠'/'
    String popper_class() default "";//	自定义浮层类名	string	—	—
    String placeholder() default "";//	输入框占位文本	string	—	请选择
    String disabled() default "";//	是否禁用	boolean	—	false
    String clearable() default "";//	是否支持清空选项	boolean	—	false
    String expand_trigger() default "";//	次级菜单的展开方式	string	click / hover	click
    String show_all_levels() default "";//	输入框中是否显示选中值的完整路径	boolean	—	true
    String filterable() default "";//	是否可搜索选项	boolean	—	—
    String debounce() default "";//	搜索关键词输入的去抖延迟，毫秒	number	—	300
    String change_on_select() default "";//	是否允许选择任意一级的选项	boolean	—	false
    String size() default "";//	尺寸	string	medium / small / mini	—
    String before_filter() default "";//	筛选之前的钩子，参数为输入的值，若返回 false 或者返回 Promise 且被 reject，则停止筛选	function(value)	—	—
}
