package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value() default "";
    String style() default "padding:15px; background: #FCFCFC";
}
