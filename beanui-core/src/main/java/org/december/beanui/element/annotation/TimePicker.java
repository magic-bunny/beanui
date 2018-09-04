package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface TimePicker {
    String label() default "";
    String readonly() default "";//	完全只读	boolean	—	false
    String disabled() default "";//	禁用	boolean	—	false
    String editable() default "";//	文本框可输入	boolean	—	true
    String clearable() default "";//	是否显示清除按钮	boolean	—	true
    String size() default "";//	输入框尺寸	string	medium / small / mini	—
    String placeholder() default "";//	非范围选择时的占位内容	string	—	—
    String start_placeholder() default "";//	范围选择时开始日期的占位内容	string	—	—
    String end_placeholder() default "";//	范围选择时开始日期的占位内容	string	—	—
    String is_range() default "";//	是否为时间范围选择，仅对<el_time_picker>有效	boolean	—	false
    String arrow_control() default "";//	是否使用箭头进行时间选择，仅对<el_time_picker>有效	boolean	—	false
    String value() default "";//	绑定值	date(TimePicker) / string(TimeSelect)	—	—
    String align() default "";//	对齐方式	string	left / center / right	left
    String popper_class() default "";//	TimePicker 下拉框的类名	string	—	—
    String picker_options() default "";//	当前时间日期选择器特有的选项参考下表	object	—	{}
    String range_separator() default "";//	选择范围时的分隔符	string	_	'_'
    String value_format() default "";//	可选，仅TimePicker时可用，绑定值的格式。不指定则绑定值为 Date 对象	string	见日期格式	—
    String default_value() default "";//	可选，选择器打开时默认显示的时间	Date(TimePicker) / string(TimeSelect)	可被new Date()解析(TimePicker) / 可选值(TimeSelect)	—
    String name() default "";//	原生属性	string	—	—
    String prefix_icon() default "";//	自定义头部图标的类名	string	—	el_icon_time
    String clear_icon() default "";//	自定义清空图标的类名	string	—	el_icon_circle_close
}
