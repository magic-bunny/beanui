package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RadioButton {
    String label() default "";//	Radio 的 value	string / number	—	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String name() default "";//	原生 name 属性	string	—	—
}
