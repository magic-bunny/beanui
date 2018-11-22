package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface SVG {
    String label() default "";
    String tag() default "svg-icon";
    String icon_class() default "";
    String style() default "";
}
