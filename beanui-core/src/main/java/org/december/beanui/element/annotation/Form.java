package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Form {
    String model() default "";//	表单数据对象	object	—	—
    String rules() default "";//	表单验证规则	object	—	—
    String inline() default "";//	行内表单模式	boolean	—	false
    String label_position() default "";//	表单域标签的位置	string	right/left/top	right
    String label_width() default "";//	表单域标签的宽度，作为 Form 直接子元素的 form_item 会继承该值	string	—	—
    String label_suffix() default "";//	表单域标签的后缀	string	—	—
    String show_message() default "";//	是否显示校验错误信息	boolean	—	true
    String inline_message() default "";//	是否以行内形式展示校验信息	boolean	—	false
    String status_icon() default "";//	是否在输入框中显示校验结果反馈图标	boolean	—	false
    String validate_on_rule_change() default "";//	是否在 rules 属性改变后立即触发一次验证	boolean	—	true
    String size() default "";//	用于控制该表单内组件的尺寸	string	medium / small / mini	—
    String disabled() default "";//	是否禁用该表单内的所有组件。若设置为 true，则表单内组件上的 disabled 属性不再生效	boolean	—	false
    String tag() default "el-form";
    String title() default "";
}
