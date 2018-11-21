package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MarkdownEditor {
    String label() default "";
    String id() default "contentEditor";
    String tag() default "markdown-editor";
    String ref() default "contentEditor";
    String v_model() default "";
}
