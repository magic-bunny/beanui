package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CardPanel {
    String svg() default "";
    String title() default "";
    String startVal() default "0";
    String endVal() default "0";
    String duration() default "3000";
    String tag() default "card-panel";
    String label() default "";
}
