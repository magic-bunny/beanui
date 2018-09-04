package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Tag {
    String type() default "";//	主题	string	success/info/warning/danger	—
    String closable() default "";//	是否可关闭	boolean	—	false
    String disable_transitions() default "";//	是否禁用渐变动画	boolean	—	false
    String hit() default "";//	是否有边框描边	boolean	—	false
    String color() default "";//	背景色	string	—	—
    String size() default "";//	尺寸	string	medium / small / mini	—
}
