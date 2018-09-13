package org.december.beanui.event.annotation;

import org.december.beanui.event.Method;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Created {
    Class rest();
    String func();
    String requestForm() default "";
    String responseForm() default "";
    String path() default "";
    String method() default Method.GET;
    String jscode() default "";
}
