package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Card {
    class Shadow {
        private Shadow() {
        }

        public static final String ALWAYS = "always";
        public static final String HOVER = "hover";
        public static final String NEVER = "never";
    }

    String title() default "";
    String header() default "";//	设置 header，也可以通过 slot#header 传入 DOM	string	—	—
    String body_style() default "";//	设置 body 的样式	object	—	{ padding: '20px' }
    String shadow() default "";//	设置阴影显示时机	string	always / hover / never	always
    String svg() default "";
    String tag() default "el-card";
    String[] data() default {};
}
