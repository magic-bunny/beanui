package org.december.beanui.event.annotation;

import org.december.beanui.event.Method;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Clear.Values.class)
public @interface Clear {
    String type() default "clear";
    Class rest() default Clear.class;
    String func() default "";
    String requestForm() default "";
    String responseForm() default "";
    String path() default "";
    String method() default Method.GET;
    String modifier() default "";
    String message() default "";
    String confirmMessage() default "";
    String beforeRequest() default "";
    String afterRequest() default "";

    @Documented
    @Target(ElementType.FIELD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Values {
        Clear[] value();
    }
}
