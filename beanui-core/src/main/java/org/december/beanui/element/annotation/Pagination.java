package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Pagination {
    String label() default "";
    String small() default "";//	是否使用小型分页样式	boolean	—	false
    String background() default "";//	是否为分页按钮添加背景色	boolean	—	false
    String page_size() default "";//	每页显示条目个数，支持 .sync 修饰符	number	—	10
    String total() default "";//	总条目数	number	—	—
    String page_count() default "";//	总页数，total 和 page_count 设置任意一个就可以达到显示页码的功能；如果要支持 page_sizes 的更改，则需要使用 total 属性	Number	—	—
    String pager_count() default "";//	页码按钮的数量，当总页数超过该值时会折叠	number	大于等于 5 且小于等于 21 的奇数	7
    String current_page() default "";//	当前页数，支持 .sync 修饰符	number	—	1
    String layout() default "";//	组件布局，子组件名用逗号分隔	String	sizes, prev, pager, next, jumper, _>, total, slot	'prev, pager, next, jumper, _>, total'
    String page_sizes() default "";//	每页显示个数选择器的选项设置	number[]	—	[10, 20, 30, 40, 50, 100]
    String popper_class() default "";//	每页显示个数选择器的下拉框类名	string	—	—
    String prev_text() default "";//	替代图标显示的上一页文字	string	—	—
    String next_text() default "";//	替代图标显示的下一页文字	string	—	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String tag() default "el-pagination";
    String v_model() default "";
}
