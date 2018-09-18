package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Transfer {
    String label() default "";
    String data() default "";//	Transfer 的数据源	array[{ key, label, disabled }]	—	[ ]
    String filterable() default "";//	是否可搜索	boolean	—	false
    String filter_placeholder() default "";//	搜索框占位符	string	—	请输入搜索内容
    String filter_method() default "";//	自定义搜索方法	function	—	—
    String target_order() default "";//	右侧列表元素的排序策略：若为 original，则保持与数据源相同的顺序；若为 push，则新加入的元素排在最后；若为 unshift，则新加入的元素排在最前	string	original / push / unshift	original
    String titles() default "";//	自定义列表标题	array	—	['列表 1', '列表 2']
    String button_texts() default "";//	自定义按钮文案	array	—	[ ]
    String render_content() default "";//	自定义数据项渲染函数	function(h, option)	—	—
    String format() default "";//	列表顶部勾选状态文案	object{noChecked, hasChecked}	—	{ noChecked: '${checked}/${total}', hasChecked: '${checked}/${total}' }
    String props() default "";//	数据源的字段别名	object{key, label, disabled}	—	—
    String left_default_checked() default "";//	初始状态下左侧列表的已勾选项的 key 数组	array	—	[ ]
    String right_default_checked() default "";//	初始状态下右侧列表的已勾选项的 key 数组	array	—	[ ]
    String tag() default "el-transfer";
}
