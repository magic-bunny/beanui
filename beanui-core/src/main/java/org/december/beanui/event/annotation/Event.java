package org.december.beanui.event.annotation;

import org.december.beanui.event.Method;

import javax.xml.stream.events.EndElement;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Event.Values.class)
public @interface Event {
    String type();
    Class rest() default Event.class;
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
    @Param1
    String param1() default "";
    @Param2
    String param2() default "";
    @Param3
    String param3() default "";
    @Param4
    String param4() default "";

    @Documented
    @Target({ElementType.TYPE, ElementType.FIELD})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Values {
        Event[] value();
    }
}
