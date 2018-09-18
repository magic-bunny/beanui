package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface FormItem {
    String prop() default "";//	表单域 model 字段，在使用 validate、resetFields 方法的情况下，该属性是必填的	string	传入 Form 组件的 model 中的字段	—
    String label() default "";//	标签文本	string	—	—
    String label_width() default "";//	表单域标签的的宽度，例如 '50px'	string	—	—
    String required() default "";//	是否必填，如不设置，则会根据校验规则自动生成	boolean	—	false
    String rules() default "";//	表单验证规则	object	—	—
    String error() default "";//	表单域验证错误信息, 设置该值会使表单验证状态变为error，并显示该错误信息	string	—	—
    String show_message() default "";//	是否显示校验错误信息	boolean	—	true
    String inline_message() default "";//	以行内形式展示校验信息	boolean	—	false
    String size() default "";//	用于控制该表单域下组件的尺寸	string	medium / small / mini
    String tag() default "el-form-item";
}
