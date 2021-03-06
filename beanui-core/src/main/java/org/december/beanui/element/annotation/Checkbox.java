package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Checkbox {
    String text() default "";
    String label() default "";//	选中状态的值（只有在checkbox_group或者绑定对象类型为array时有效）	string / number / boolean	—	—
    String true_label() default "";//	选中时的值	string / number	—	—
    String false_label() default "";//	没有选中时的值	string / number	—	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String border() default "";//	是否显示边框	boolean	—	false
    String size() default "";//	Checkbox 的尺寸，仅在 border 为真时有效	string	medium / small / mini	—
    String name() default "";//	原生 name 属性	string	—	—
    String checked() default "";//	当前是否勾选	boolean	—	false
    String indeterminate() default "";//	设置 indeterminate 状态，只负责样式控制	boolean	—	false
    String tag() default "el-checkbox";
    String v_model() default "";
}
