package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckboxButtonGroup {
    String size() default "";//	多选框组尺寸，仅对按钮形式的 Checkbox 或带有边框的 Checkbox 有效	string	medium / small / mini	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String min() default "";//	可被勾选的 checkbox 的最小数量	number	—	—
    String max() default "";//	可被勾选的 checkbox 的最大数量	number	—	—
    String text_color() default "";//	按钮形式的 Checkbox 激活时的文本颜色	string	—	#ffffff
    String fill() default "";//	按钮形式的 Checkbox 激活时的填充色和边框色	string	—	#409EFF
    String data() default "";
    String label() default "";
    String tag() default "el-checkbox-group";
}
