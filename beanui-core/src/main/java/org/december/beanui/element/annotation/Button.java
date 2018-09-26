package org.december.beanui.element.annotation;

import org.december.beanui.element.Size;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Button {
    class NativeType {
        public static final String BUTTON = "button";
        public static final String SUBMIT = "submit";
        public static final String RESET = "reset";

        private NativeType() {
        }
    }

    String text() default "";
    String size() default "";//尺寸	string	medium / small / mini	—
    String type() default "";//类型	string	primary / success / warning / danger / info / text	—
    String plain() default "";//是否朴素按钮	boolean	—	false
    String round() default "";//是否圆角按钮	boolean	—	false
    String circle() default "";//是否圆形按钮	boolean	—	false
    String loading() default "";//是否加载中状态	boolean	—	false
    String disabled() default "";//是否禁用状态	boolean	—	false
    String icon() default "";//图标类名	string	—	—
    String autofocus() default "";//是否默认聚焦	boolean	—	false
    String native_type() default "";//原生 type 属性	string	button / submit / reset	button
    String style() default "";
    String label() default "";
    String tag() default "el-button";
}
