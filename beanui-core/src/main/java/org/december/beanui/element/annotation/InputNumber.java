package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InputNumber {
    String value() default "";//	绑定值	number	—	—
    String min() default "";//	设置计数器允许的最小值	number	—	_Infinity
    String max() default "";//	设置计数器允许的最大值	number	—	Infinity
    String step() default "";//	计数器步长	number	—	1
    String precision() default "";//	数值精度	number	—	—
    String size() default "";//	计数器尺寸	string	large, small	—
    String disabled() default "";//	是否禁用计数器	boolean	—	false
    String controls() default "";//	是否使用控制按钮	boolean	—	true
    String controls_position() default "";//	控制按钮位置	string	right	_
    String name() default "";//	原生属性	string	—	—
    String label() default "";//	输入框关联的label文字	string	—	—
    String tag() default "el-input-number";
}
