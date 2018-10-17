package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Link {
    String to();
    String tag() default "";
    String replace() default "";
    String append() default "";
    String active_class() default "";
    String exact() default "";
    String event() default "";
    String exact_active_class() default "";
}
