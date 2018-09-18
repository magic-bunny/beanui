package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Rate {
    String label() default "";
    String max() default "";//	最大分值	number	—	5
    String disabled() default "";//	是否为只读	boolean	—	false
    String allow_half() default "";//	是否允许半选	boolean	—	false
    String low_threshold() default "";//	低分和中等分数的界限值，值本身被划分在低分中	number	—	2
    String high_threshold() default "";//	高分和中等分数的界限值，值本身被划分在高分中	number	—	4
    String colors() default "";//	icon 的颜色数组，共有 3 个元素，为 3 个分段所对应的颜色	array	—	['#F7BA2A', '#F7BA2A', '#F7BA2A']
    String void_color() default "";//	未选中 icon 的颜色	string	—	#C6D1DE
    String disabled_void_color() default "";//	只读时未选中 icon 的颜色	string	—	#EFF2F7
    String icon_classes() default "";//	icon 的类名数组，共有 3 个元素，为 3 个分段所对应的类名	array	—	['el_icon_star_on', 'el_icon_star_on','el_icon_star_on']
    String void_icon_class() default "";//	未选中 icon 的类名	string	—	el_icon_star_off
    String disabled_void_icon_class() default "";//	只读时未选中 icon 的类名	string	—	el_icon_star_on
    String show_text() default "";//	是否显示辅助文字，若为真，则会从 texts 数组中选取当前分数对应的文字内容	boolean	—	false
    String show_score() default "";//	是否显示当前分数，show_score 和 show_text 不能同时为真	boolean	—	false
    String text_color() default "";//	辅助文字的颜色	string	—	#1F2D3D
    String texts() default "";//	辅助文字数组	array	—	['极差', '失望', '一般', '满意', '惊喜']
    String score_template() default "";//	分数显示模板	string	—	{value}
    String tag() default "el-rate";
}
