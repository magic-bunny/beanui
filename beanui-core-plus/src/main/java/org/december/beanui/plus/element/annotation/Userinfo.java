package org.december.beanui.plus.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Userinfo {
    Class rest();
    String func();
}
