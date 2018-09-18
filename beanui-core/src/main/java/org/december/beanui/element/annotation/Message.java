package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Message {
    String message() default "";//	消息文字	string / VNode	—	—
    String type() default "";//	主题	string	success/warning/info/error	info
    String iconClass() default "";//	自定义图标的类名，会覆盖 type	string	—	—
    String dangerouslyUseHTMLString() default "";//	是否将 message 属性作为 HTML 片段处理	boolean	—	false
    String customClass() default "";//	自定义类名	string	—	—
    String duration() default "";//	显示时间, 毫秒。设为 0 则不会自动关闭	number	—	3000
    String showClose() default "";//	是否显示关闭按钮	boolean	—	false
    String center() default "";//	文字是否居中	boolean	—	false
    String onClose() default "";//	关闭时的回调函数, 参数为被关闭的 message 实例	function	—	—
    String tag() default "el-message";
}
