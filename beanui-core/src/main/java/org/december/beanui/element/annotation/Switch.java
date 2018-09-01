package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Switch {
    String disabled() default "";//	是否禁用	boolean	—	false
    String width() default "";//	switch 的宽度（像素）	number	—	40
    String active_icon_class() default "";//	switch 打开时所显示图标的类名，设置此项会忽略 active-text	string	—	—
    String inactive_icon_class() default "";//	switch 关闭时所显示图标的类名，设置此项会忽略 inactive-text	string	—	—
    String active_text() default "";//	switch 打开时的文字描述	string	—	—
    String inactive_text() default "";//	switch 关闭时的文字描述	string	—	—
    String active_value() default "";//	switch 打开时的值	boolean / string / number	—	true
    String inactive_value() default "";//	switch 关闭时的值	boolean / string / number	—	false
    String active_color() default "";//	switch 打开时的背景色	string	—	#409EFF
    String inactive_color() default "";//	switch 关闭时的背景色	string	—	#C0CCDA
    String name() default "";//	switch 对应的 name 属性	string
    String label() default "";
}
