package org.december.beanui.chart.annotation;

import org.december.beanui.chart.Config;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Legend {
    String tag() default "legend";
    String type() default "";
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
    String orient() default "";
    String align() default "";
    String padding() default "";
    String itemGap() default "";
    String itemWidth() default "";
    String itemHeight() default "";
    String symbolKeepAspect() default "";
    String formatter() default "";
    String selectedMode() default "";
    String inactiveColor() default "";
    String selected() default "";
    String textStyle() default "";
    String tooltip() default "";
    String data() default Config.DEFAULT_PROPERTY;
    String backgroundColor() default "";
    String borderColor() default "";
    String borderWidth() default "";
    String borderRadius() default "";
    String shadowBlur() default "";
    String shadowColor() default "";
    String shadowOffsetX() default "";
    String shadowOffsetY() default "";
    String scrollDataIndex() default "";
    String pageButtonItemGap() default "";
    String pageButtonGap() default "";
    String pageButtonPosition() default "";
    String pageFormatter() default "";
    String pageIcons() default "";
    String pageIconColor() default "";
    String pageIconInactiveColor() default "";
    String pageIconSize() default "";
    String pageTextStyle() default "";
    String animation() default "";
    String animationDurationUpdate() default "";

    class Type {
        public static final String PLAIN = "plain";
        public static final String SCROLL = "scroll";
    }
}
