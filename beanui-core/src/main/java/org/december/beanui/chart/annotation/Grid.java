package org.december.beanui.chart.annotation;

import org.december.beanui.chart.Config;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Grid {
    String tag() default "grid";
    String id() default "";
    String show() default "";
    String zlevel() default "";
    String z() default "";
    String left() default "";
    String top() default "";
    String right() default "";
    String bottom() default "";
    String width() default "";
    String height() default "";
    String containLabel() default "";
    String backgroundColor() default "";
    String borderColor() default "";
    String borderWidth() default "";
    String shadowBlur() default "";
    String shadowColor() default "";
    String shadowOffsetX() default "";
    String shadowOffsetY() default "";
    String tooltip() default "";
}
