package org.december.beanui.event.annotation;

import org.december.beanui.event.Method;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Created.Values.class)
public @interface Created {
    String type() default "created";
    Class rest() default Created.class;
    String func() default "";
    String requestForm() default "";
    String responseForm() default "";
    String path() default "";
    String method() default Method.GET;
    String message() default "";
    String confirmMessage() default "";
    String beforeRequest() default "";
    String afterRequest() default "";

    @Documented
    @Target(ElementType.TYPE)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Values {
        Created[] value();
    }
}
