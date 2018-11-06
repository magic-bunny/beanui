package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface WordEditor {
    String label() default "";
    String tag() default "tinymce";
}
