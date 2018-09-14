package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RadioGroup {
    String size() default "";//	单选框组尺寸，仅对按钮形式的 Radio 或带有边框的 Radio 有效	string	medium / small / mini	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String text_color() default "";//	按钮形式的 Radio 激活时的文本颜色	string	—	#ffffff
    String fill() default "";//	按钮形式的 Radio 激活时的填充色和边框色	string	—	#409EFF

}
