package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String label() default "";
    String data() default "";//	显示的数据	array	—	—
    String height() default "";//	Table 的高度，默认为自动高度。如果 height 为 number 类型，单位 px；如果 height 为 string 类型，则这个高度会设置为 Table 的 style.height 的值，Table 的高度会受控于外部样式。	string/number	—	—
    String max_height() default "";//	Table 的最大高度	string/number	—	—
    String stripe() default "";//	是否为斑马纹 table	boolean	—	false
    String border() default "";//	是否带有纵向边框	boolean	—	false
    String size() default "";//	Table 的尺寸	string	medium / small / mini	—
    String fit() default "";//	列的宽度是否自撑开	boolean	—	true
    String show_header() default "";//	是否显示表头	boolean	—	true
    String highlight_current_row() default "";//	是否要高亮当前行	boolean	—	false
    String current_row_key() default "";//	当前行的 key，只写属性	String,Number	—	—
    String row_class_name() default "";//	行的 className 的回调方法，也可以使用字符串为所有行设置一个固定的 className。	Function({row, rowIndex})/String	—	—
    String row_style() default "";//	行的 style 的回调方法，也可以使用一个固定的 Object 为所有行设置一样的 Style。	Function({row, rowIndex})/Object	—	—
    String cell_class_name() default "";//	单元格的 className 的回调方法，也可以使用字符串为所有单元格设置一个固定的 className。	Function({row, column, rowIndex, columnIndex})/String	—	—
    String cell_style() default "";//	单元格的 style 的回调方法，也可以使用一个固定的 Object 为所有单元格设置一样的 Style。	Function({row, column, rowIndex, columnIndex})/Object	—	—
    String header_row_class_name() default "";//	表头行的 className 的回调方法，也可以使用字符串为所有表头行设置一个固定的 className。	Function({row, rowIndex})/String	—	—
    String header_row_style() default "";//	表头行的 style 的回调方法，也可以使用一个固定的 Object 为所有表头行设置一样的 Style。	Function({row, rowIndex})/Object	—	—
    String header_cell_class_name() default "";//	表头单元格的 className 的回调方法，也可以使用字符串为所有表头单元格设置一个固定的 className。	Function({row, column, rowIndex, columnIndex})/String	—	—
    String header_cell_style() default "";//	表头单元格的 style 的回调方法，也可以使用一个固定的 Object 为所有表头单元格设置一样的 Style。	Function({row, column, rowIndex, columnIndex})/Object	—	—
    String row_key() default "";//	行数据的 Key，用来优化 Table 的渲染；在使用 reserve_selection 功能的情况下，该属性是必填的。类型为 String 时，支持多层访问：user.info.id，但不支持 user.info[0].id，此种情况请使用 Function。	Function(row)/String	—	—
    String empty_text() default "";//	空数据时显示的文本内容，也可以通过 slot="empty" 设置	String	—	暂无数据
    String default_expand_all() default "";//	是否默认展开所有行，当 Table 中存在 type="expand" 的 Column 的时候有效	Boolean	—	false
    String expand_row_keys() default "";//	可以通过该属性设置 Table 目前的展开行，需要设置 row_key 属性才能使用，该属性为展开行的 keys 数组。	Array	—
    String default_sort() default "";//	默认的排序列的 prop 和顺序。它的prop属性指定默认的排序的列，order指定默认排序的顺序	Object	order: ascending, descending	如果只指定了prop, 没有指定order, 则默认顺序是ascending
    String tooltip_effect() default "";//	tooltip effect 属性	String	dark/light
    String show_summary() default "";//	是否在表尾显示合计行	Boolean	—	false
    String sum_text() default "";//	合计行第一列的文本	String	—	合计
    String summary_method() default "";//	自定义的合计计算方法	Function({ columns, data })	—	—
    String span_method() default "";//	合并行或列的计算方法	Function({ row, column, rowIndex, columnIndex })	—	—
    String select_on_indeterminate() default "";//	在多选表格中，当仅有部分行被选中时，点击表头的多选框时的行为。若为 true，则选中所有行；若为 false，则取消选择所有行	Boolean	—	true
}
