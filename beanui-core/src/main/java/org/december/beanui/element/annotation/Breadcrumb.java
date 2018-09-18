package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Breadcrumb {
    String separator() default "";//	分隔符	string	—	斜杠'/'
    String separator_class() default "";//	图标分隔符 class	string	—	-
    String tag() default "el-breadcrumb";
}
