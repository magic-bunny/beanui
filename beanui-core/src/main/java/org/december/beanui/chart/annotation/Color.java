package org.december.beanui.chart.annotation;

import org.december.beanui.chart.Config;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Color {
    String tag() default "color";
    String value() default Config.DEFAULT_PROPERTY;
}
