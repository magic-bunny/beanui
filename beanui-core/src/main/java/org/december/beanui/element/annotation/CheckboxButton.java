package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckboxButton {
    String label() default "";//	选中状态的值（只有在checkbox_group或者绑定对象类型为array时有效）	string / number / boolean	—	—
    String true_label() default "";//	选中时的值	string / number	—	—
    String false_label() default "";//	没有选中时的值	string / number	—	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String name() default "";//	原生 name 属性	string	—	—
    String checked() default "";//	当前是否勾选	boolean	—	false
    String tag() default "el-checkbox-button";
}
