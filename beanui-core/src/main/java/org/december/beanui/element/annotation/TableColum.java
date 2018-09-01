package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface TableColum {
    String type() default "";//	对应列的类型。如果设置了 selection 则显示多选框；如果设置了 index 则显示该行的索引（从 1 开始计算）；如果设置了 expand 则显示为一个可展开的按钮	string	selection/index/expand	—
    String index() default "";//	如果设置了 type=index，可以通过传递 index 属性来自定义索引	string, Function(index)	_	_
    String column_key() default "";//	column 的 key，如果需要使用 filter_change 事件，则需要此属性标识是哪个 column 的筛选条件	string	—	—
    String label() default "";//	显示的标题	string	—	—
    String prop() default "";//	对应列内容的字段名，也可以使用 property 属性	string	—	—
    String width() default "";//	对应列的宽度	string	—	—
    String min_width() default "";//	对应列的最小宽度，与 width 的区别是 width 是固定的，min_width 会把剩余宽度按比例分配给设置了 min_width 的列	string	—	—
    String fixed() default "";//	列是否固定在左侧或者右侧，true 表示固定在左侧	string, boolean	true, left, right	—
    String render_header() default "";//	列标题 Label 区域渲染使用的 Function	Function(h, { column, $index })	—	—
    String sortable() default "";//	对应列是否可以排序，如果设置为 'custom'，则代表用户希望远程排序，需要监听 Table 的 sort_change 事件	boolean, string	true, false, 'custom'	false
    String sort_method() default "";//	对数据进行排序的时候使用的方法，仅当 sortable 设置为 true 的时候有效，需返回一个数字，和 Array.sort 表现一致	Function(a, b)	—	—
    String sort_by() default "";//	指定数据按照哪个属性进行排序，仅当 sortable 设置为 true 且没有设置 sort_method 的时候有效。如果 sort_by 为数组，则先按照第 1 个属性排序，如果第 1 个相等，再按照第 2 个排序，以此类推	String/Array/Function(row, index)	—	—
    String sort_orders() default "";//	数据在排序时所使用排序策略的轮转顺序，仅当 sortable 为 true 时有效。需传入一个数组，随着用户点击表头，该列依次按照数组中元素的顺序进行排序	array	数组中的元素需为以下三者之一：ascending 表示升序，descending 表示降序，null 表示还原为原始顺序	['ascending', 'descending', null]
    String resizable() default "";//	对应列是否可以通过拖动改变宽度（需要在 el_table 上设置 border 属性为真）	boolean	—	true
    String formatter() default "";//	用来格式化内容	Function(row, column, cellValue, index)	—	—
    String show_overflow_tooltip() default "";//	当内容过长被隐藏时显示 tooltip	Boolean	—	false
    String align() default "";//	对齐方式	String	left/center/right	left
    String header_align() default "";//	表头对齐方式，若不设置该项，则使用表格的对齐方式	String	left/center/right	—
    String class_name() default "";//	列的 className	string	—	—
    String label_class_name() default "";//	当前列标题的自定义类名	string	—	—
    String selectable() default "";//	仅对 type=selection 的列有效，类型为 Function，Function 的返回值用来决定这一行的 CheckBox 是否可以勾选	Function(row, index)	—	—
    String reserve_selection() default "";//	仅对 type=selection 的列有效，类型为 Boolean，为 true 则会在数据更新之后保留之前选中的数据（需指定 row_key）	Boolean	—	false
    String filters() default "";//	数据过滤的选项，数组格式，数组中的元素需要有 text 和 value 属性。	Array[{ text, value }]	—	—
    String filter_placement() default "";//	过滤弹出框的定位	String	与 Tooltip 的 placement 属性相同	—
    String filter_multiple() default "";//	数据过滤的选项是否多选	Boolean	—	true
    String filter_method() default "";//	数据过滤使用的方法，如果是多选的筛选项，对每一条数据会执行多次，任意一次返回 true 就会显示。	Function(value, row, column)	—	—
    String filtered_value() default "";//	选中的数据过滤项，如果需要自定义表头过滤的渲染方式，可能会需要此属性。	Array	—	—
}
