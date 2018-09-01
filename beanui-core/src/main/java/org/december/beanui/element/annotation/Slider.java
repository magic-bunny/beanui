package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Slider {
    String min() default "";//	最小值	number	—	0
    String max() default "";//	最大值	number	—	100
    String disabled() default "";//	是否禁用	boolean	—	false
    String step() default "";//	步长	number	—	1
    String show_input() default "";//	是否显示输入框，仅在非范围选择时有效	boolean	—	false
    String show_input_controls() default "";//	在显示输入框的情况下，是否显示输入框的控制按钮	boolean	—	true
    String input_size() default "";//	输入框的尺寸	string	large / medium / small / mini	small
    String show_stops() default "";//	是否显示间断点	boolean	—	false
    String show_tooltip() default "";//	是否显示 tooltip	boolean	—	true
    String format_tooltip() default "";//	格式化 tooltip message	function(value)	—	—
    String range() default "";//	是否为范围选择	boolean	—	false
    String vertical() default "";//	是否竖向模式	boolean	—	false
    String height() default "";//	Slider 高度，竖向模式时必填	string	—	—
    String label() default "";//	屏幕阅读器标签	string	—	—
    String debounce() default "";//	输入时的去抖延迟，毫秒，仅在show_input等于true时有效	number	—	300
    String tooltip_class() default "";//	tooltip 的自定义类名	string	—	—
}
