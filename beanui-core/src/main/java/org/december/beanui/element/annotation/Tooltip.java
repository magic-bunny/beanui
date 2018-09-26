package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Tooltip {
    class Placement {
        public static final String TOP = "top";
        public static final String TOP_START = "top_start";
        public static final String TOP_END = "top_end";
        public static final String BOTTOM = "bottom";
        public static final String BOTTOM_START = "bottom_start";
        public static final String BOTTOM_END = "bottom_end";
        public static final String LEFT = "left";
        public static final String LEFT_START = "left_start";
        public static final String LEFT_END = "left_end";
        public static final String RIGHT = "right";
        public static final String RIGHT_START = "right_start";
        public static final String RIGHT_END = "right_end";
    }

    String effect() default "";	//默认提供的主题	String	dark/light	dark
    String content() default "";	//显示的内容，也可以通过 slot#content 传入 DOM	String	—	—
    String placement() default "";	//Tooltip 的出现位置	String	top/top_start/top_end/bottom/bottom_start/bottom_end/left/left_start/left_end/right/right_start/right_end	bottom
    String value() default "";//(v_model)	状态是否可见	Boolean	—	false
    String disabled() default "";	//Tooltip 是否可用	Boolean	—	false
    String offset() default "";//	出现位置的偏移量	Number	—	0
    String transition() default "";	//定义渐变动画	String	—	el_fade_in_linear
    String visible_arrow() default "";//	是否显示 Tooltip 箭头，更多参数可见Vue_popper	Boolean	—	true
    String popper_options() default "";//	popper.js 的参数	Object	参考 popper.js 文档	{ boundariesElement: 'body', gpuAcceleration: false }
    String open_delay() default "";//	延迟出现，单位毫秒	Number	—	0
    String manual() default "";//	手动控制模式，设置为 true 后，mouseenter 和 mouseleave 事件将不会生效	Boolean	—	false
    String popper_class() default "";//	为 Tooltip 的 popper 添加类名	String	—	—
    String enterable() default "";//	鼠标是否可进入到 tooltip 中	Boolean	—	true
    String hide_after() default "";//	Tooltip 出现后自动隐藏延时，单位毫秒，为 0 则不会自动隐藏	number	—	0
    String tag() default "el-tooltip";
}
