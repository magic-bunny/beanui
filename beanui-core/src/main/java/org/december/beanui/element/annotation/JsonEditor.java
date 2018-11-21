package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonEditor {
    String label() default "";
    String tag() default "json-editor";
    String ref() default "jsonEditor";
    String v_model() default "";
}
