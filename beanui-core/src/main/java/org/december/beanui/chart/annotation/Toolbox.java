package org.december.beanui.chart.annotation;

import org.december.beanui.chart.Config;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Toolbox {
    String tag() default "toolbox";
    String id() default "";
    String show() default "";
    String orient() default "";
    String itemSize() default "";
    String itemGap() default "";
    String showTitle() default "";
    String feature() default Config.DEFAULT_PROPERTY;
    String iconStyle() default "";
    String emphasis() default "";
    String zlevel() default "";
    String z() default "";
    String left() default "";
    String top() default "";
    String right() default "";
    String bottom() default "";
    String width() default "";
    String height() default "";

    @interface Feature {
        String saveAsImage();
        String restore();
        String dataView();
        String dataZoom();
        String magicType();
        String brush();
    }
}
