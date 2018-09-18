package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Radio {
    String label() default "";//	Radio 的 value	string / number / boolean	—	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String border() default "";//	是否显示边框	boolean	—	false
    String size() default "";//	Radio 的尺寸，仅在 border 为真时有效	string	medium / small / mini	—
    String name() default "";//	原生 name 属性	string	—	—
    String tag() default "el-radio";
}
