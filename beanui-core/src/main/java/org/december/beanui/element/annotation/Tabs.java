package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabs {
    String type() default "";//	风格类型	string	card/border-card	—
    String closable() default "";//	标签是否可关闭	boolean	—	false
    String addable() default "";//	标签是否可增加	boolean	—	false
    String editable() default "";//	标签是否同时可增加和关闭	boolean	—	false
    String value() default "";//	绑定值，选中选项卡的 name	string	—	第一个选项卡的 name
    String tab_position() default "";//	选项卡所在位置	string	top/right/bottom/left	top
    String stretch() default "";//	标签的宽度是否自撑开	boolean	-	false
    String before_leave() default "";//	切换标签之前的钩子，若返回 false 或者返回 Promise 且被 reject，则阻止切换。	Function(activeName, oldActiveName)	—	—
    String[] data() default {};

    class Type {
        public static final String CARD = "card";
        public static final String BORDER_CARD = "border-card";
    }

    @Documented
    @Target(ElementType.FIELD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Item {
        String name() default "";
        String label() default "";
        String disabled() default "";
        String closabel() default "";
        String lazy() default "";
    }
}