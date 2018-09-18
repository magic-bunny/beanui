package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePicker {
    String label() default "";
    String readonly() default "";//完全只读	boolean	—	false
    String disabled() default "";//	禁用	boolean	—	false
    String editable() default "";//	文本框可输入	boolean	—	true
    String clearable() default "";//	是否显示清除按钮	boolean	—	true
    String size() default "";//	输入框尺寸	string	large, small, mini	—
    String placeholder() default "";//	非范围选择时的占位内容	string	—	—
    String start_placeholder() default "";//	范围选择时开始日期的占位内容	string	—	—
    String end_placeholder() default "";//	范围选择时结束日期的占位内容	string	—	—
    String type() default "";//显示类型	string	year/month/date/dates/ week/datetime/datetimerange/daterange	date
    String format() default "";//	显示在输入框中的格式	string	见日期格式	yyyy_MM_dd
    String align() default "";//	对齐方式	string	left, center, right	left
    String popper_class() default "";//	DatePicker 下拉框的类名	string	—	—
    String picker_options() default "";//	当前时间日期选择器特有的选项参考下表	object	—	{}
    String range_separator() default "";//	选择范围时的分隔符	string	—	'_'
    String default_value() default "";//	可选，选择器打开时默认显示的时间	Date	可被new Date()解析	—
    String default_time() default "";//	范围选择时选中日期所使用的当日内具体时刻	string[]	数组，长度为 2，每项值为字符串，形如12:00:00，第一项指定开始日期的时刻，第二项指定结束日期的时刻，不指定会使用时刻 00:00:00	—
    String value_format() default "";//	可选，绑定值的格式。不指定则绑定值为 Date 对象	string	见日期格式	—
    String name() default "";//	原生属性	string	—	—
    String unlink_panels() default "";//	在范围选择器里取消两个日期面板之间的联动	boolean	—	false
    String prefix_icon() default "";//	自定义头部图标的类名	string	—	el_icon_date
    String clear_icon() default "";//	自定义清空图标的类名	string	—	el_icon_circle_close
    String tag() default "el-date-picker";
}
