package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Badge {
    String value() default "";//	显示值	string, number	—	—
    String max() default "";//	最大值，超过最大值会显示 '{max}+'，要求 value 是 Number 类型	number	—	—
    String is_dot() default "";//	小圆点	boolean	—	false
    String hidden() default "";//	隐藏 badge	boolean	—	false
    String tag() default "el-badge";
}
