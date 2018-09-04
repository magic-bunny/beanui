package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ColorPicker {
    String label() default "";
    String disabled() default "";//	是否禁用	boolean	—	false
    String size() default "";//	尺寸	string	—	medium / small / mini
    String show_alpha() default "";//	是否支持透明度选择	boolean	—	false
    String color_format() default "";//	写入 v_model 的颜色的格式	string	hsl / hsv / hex / rgb	hex（show_alpha 为 false）/ rgb（show_alpha 为 true）
    String popper_class() default "";//	ColorPicker 下拉框的类名	string	—	—
    String predefine() default "";//	预定义颜色	array	—	—
}
