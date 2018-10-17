package org.december.beanui.chart.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Tooltip {
    String tag() default "tooltip";
    String show() default "";
    String trigger() default "";
    String axisPointer() default "";
    String showContent() default "";
    String alwaysShowContent() default "";
    String triggerOn() default "";
    String showDelay() default "";
    String hideDelay() default "";
    String enterable() default "";
    String renderMode() default "";
    String confine() default "";
    String transitionDuration() default "";
    String position() default "";
    String formatter() default "";
    String backgroundColor() default "";
    String borderColor() default "";
    String borderWidth() default "";
    String padding() default "";
    String textStyle() default "";
    String extraCssText() default "";

    class Trigger {
        public static final String ITEM = "item";
        public static final String AXIS = "axis";
        public static final String NONE = "none";
    }
}
