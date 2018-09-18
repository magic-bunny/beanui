package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Input {
    String style() default "";
    String type() default "";//	类型	string	text，textarea 和其他 原生 input 的 type 值	text
    String value() default "";//	绑定值	string / number	—	—
    String maxlength() default "";//	原生属性，最大输入长度	number	—	—
    String minlength() default "";//	原生属性，最小输入长度	number	—	—
    String placeholder() default "";//	输入框占位文本	string	—	—
    String clearable() default "";//	是否可清空	boolean	—	false
    String disabled() default "";//	禁用	boolean	—	false
    String size() default "";//	输入框尺寸，只在 type!="textarea" 时有效	string	medium / small / mini	—
    String prefix_icon() default "";//	输入框头部图标	string	—	—
    String suffix_icon() default "";//	输入框尾部图标	string	—	—
    String rows() default "";//	输入框行数，只对 type="textarea" 有效	number	—	2
    String autosize() default "";//	自适应内容高度，只对 type="textarea" 有效，可传入对象，如，{ minRows: 2, maxRows: 6 }	boolean / object	—	false
    String auto_complete() default "";//	原生属性，自动补全	string	on, off	off
    String name() default "";//	原生属性	string	—	—
    String readonly() default "";//	原生属性，是否只读	boolean	—	false
    String max() default "";//	原生属性，设置最大值	—	—	—
    String min() default "";//	原生属性，设置最小值	—	—	—
    String step() default "";//	原生属性，设置输入字段的合法数字间隔	—	—	—
    String resize() default "";//	控制是否能被用户缩放	string	none, both, horizontal, vertical	—
    String autofocus() default "";//	原生属性，自动获取焦点	boolean	true, false	false
    String form() default "";//	原生属性	string	—	—
    String label() default "";//	输入框关联的label文字	string	—	—
    String tabindex() default "";//	输入框的tabindex	string	-	-
    String tag() default "el-input";
}
