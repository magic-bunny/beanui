package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Progress {
    String label() default "";
    String percentage() default "";//	百分比（必填）	number	0_100	0
    String type() default "";//	进度条类型	string	line/circle	line
    String stroke_width() default "";//	进度条的宽度，单位 px	number	—	6
    String text_inside() default "";//	进度条显示文字内置在进度条内（只在 type=line 时可用）	boolean	—	false
    String status() default "";//	进度条当前状态	string	success/exception	—
    String color() default "";//	进度条背景色（会覆盖 status 状态颜色）	string	—	—
    String width() default "";//	环形进度条画布宽度（只在 type=circle 时可用）	number		126
    String show_text() default "";//	是否显示进度条文字内容	boolean	—	true
    String tag() default "el-progress";

    class Type {
        public static final String LINE = "line";
        public static final String CIRCLE = "circle";
    }

    class Status {
        public static final String SUCCESS = "success";
        public static final String EXCEPTION = "exception";
    }
}
