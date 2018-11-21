package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Element {
    String tag() default "div";
    String label() default "";
    String style() default "";
    String v_model() default "";
}
