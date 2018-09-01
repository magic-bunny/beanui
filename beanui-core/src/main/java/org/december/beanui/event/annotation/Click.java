package org.december.beanui.event.annotation;

import org.december.beanui.event.Method;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Click {
    Class rest();
    String func();
    String path() default "";
    String method() default Method.GET;
    String modifier() default "";
    String jscode() default "";
}
