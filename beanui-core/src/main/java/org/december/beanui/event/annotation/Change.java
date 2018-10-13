package org.december.beanui.event.annotation;

import org.december.beanui.event.Method;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Change.Values.class)
public @interface Change {
    String type() default "change";
    Class rest() default Change.class;
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
        Change[] value();
    }
}
