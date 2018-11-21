package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Carousel {
    String height() default "";//	走马灯的高度	string	—	—
    String initial_index() default "";//	初始状态激活的幻灯片的索引，从 0 开始	number	—	0
    String trigger() default "";//	指示器的触发方式	string	click	—
    String autoplay() default "";//	是否自动切换	boolean	—	true
    String interval() default "";//	自动切换的时间间隔，单位为毫秒	number	—	3000
    String indicator_position() default "";//	指示器的位置	string	outside/none	—
    String arrow() default "";//	切换箭头的显示时机	string	always/hover/never	hover
    String type() default "";//	走马灯的类型	string	card	—
    String[] data() default {};

    @Documented
    @Target(ElementType.FIELD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Item {
        String name() default "";
        String label() default "";
    }
}
