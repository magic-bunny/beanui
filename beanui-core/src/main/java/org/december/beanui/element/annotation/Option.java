package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Option {
    String label() default "";
    String key() default "";
    String value() default "";
}
