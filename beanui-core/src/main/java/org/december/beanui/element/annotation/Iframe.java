package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Iframe {
    String tag() default "iframe";
    String src() default "";
    String height() default "";
    String width() default "";
    String align() default "";
    String frameborder() default "";
    String longdesc() default "";
    String marginheight() default "";
    String marginwidth() default "";
    String name() default "";
    String sandbox() default "";
    String scrolling() default "";
    String seamless() default "";
    String srcdoc() default "";

    class Align {
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
        public static final String TOP = "top";
        public static final String MIDDLE = "middle";
        public static final String BOTTOM = "bottom";
    }

    class Sandbox {
        public static final String ALLOW_FORMS = "allow-forms";
        public static final String ALLOW_SAME_ORIGIN = "allow-same-origin";
        public static final String ALLOW_SCRIPTS = "allow-scripts";
        public static final String ALLOW_TOP_NAVIGATION = "allow-top-navigation";
    }

    class Scrolling {
        public static final String YES = "yes";
        public static final String NO = "no";
        public static final String AUTO = "auto";
    }
}
