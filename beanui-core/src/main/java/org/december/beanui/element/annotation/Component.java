package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String background() default "";
    String width() default "";
    String center() default "";
    String path() default "";
    String title() default "";
    String icon() default "";
    String superPath() default "";
    String superTitle() default "";
    String superIcon() default "";
}
