package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Image {
    String label() default "";
    String style() default "";
    String src() default "";
    String height() default "";
    String width() default "";
    String alt() default "";
    String tag() default "img";
    String v_model() default "";
}
