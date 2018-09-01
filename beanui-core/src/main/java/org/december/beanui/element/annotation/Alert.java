package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Alert {
    String title() default "";//	标题，必选参数	string	—	—
    String type() default "";//	主题	string	success/warning/info/error	info
    String description() default "";//	辅助性文字。也可通过默认 slot 传入	string	—	—
    String closable() default "";//	是否可关闭	boolean	—	true
    String center() default "";//	文字是否居中	boolean	—	true
    String close_text() default "";//	关闭按钮自定义文本	string	—	—
    String show_icon() default "";//	是否显示图标	boolean	—	false
}
