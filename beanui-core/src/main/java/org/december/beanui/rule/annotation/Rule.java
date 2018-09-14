package org.december.beanui.rule.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Rule {
    String required() default "";
    String message() default "";
    String trigger() default "";
    String type() default "";
    String min() default "";
    String max() default "";
    String pattern() default "";
    String len() default "";
    String ENUM() default "";
}