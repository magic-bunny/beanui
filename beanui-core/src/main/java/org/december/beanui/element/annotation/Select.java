package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {
    String label() default "";
    String data() default "";
    String multiple() default "";//	是否多选	boolean	—	false
    String disabled() default "";//	是否禁用	boolean	—	false
    String value_key() default "";//	作为 value 唯一标识的键名，绑定值为对象类型时必填	string	—	value
    String size() default "";//	输入框尺寸	string	medium/small/mini	—
    String clearable() default "";//	单选时是否可以清空选项	boolean	—	false
    String collapse_tags() default "";//	多选时是否将选中值按文字的形式展示	boolean	—	false
    String multiple_limit() default "";//	多选时用户最多可以选择的项目数，为 0 则不限制	number	—	0
    String name() default "";//	select input 的 name 属性	string	—	—
    String auto_complete() default "";//	select input 的 autocomplete 属性	string	—	off
    String placeholder() default "";//	占位符	string	—	请选择
    String filterable() default "";//	是否可搜索	boolean	—	false
    String allow_create() default "";//	是否允许用户创建新条目，需配合 filterable 使用	boolean	—	false
    String filter_method() default "";//	自定义搜索方法	function	—	—
    String remote() default "";//	是否为远程搜索	boolean	—	false
    String remote_method() default "";//	远程搜索方法	function	—	—
    String loading() default "";//	是否正在从远程获取数据	boolean	—	false
    String loading_text() default "";//	远程加载时显示的文字	string	—	加载中
    String no_match_text() default "";//	搜索条件无匹配时显示的文字	string	—	无匹配数据
    String no_data_text() default "";//	选项为空时显示的文字	string	—	无数据
    String popper_class() default "";//	Select 下拉框的类名	string	—	—
    String reserve_keyword() default "";//	多选且可搜索时，是否在选中一个选项后保留当前的搜索关键词	boolean	—	false
    String default_first_option() default "";//	在输入框按下回车，选择第一个匹配项。需配合 filterable 或 remote 使用	boolean	_	false
    String popper_append_to_body() default "";//	是否将弹出框插入至 body 元素。在弹出框的定位出现问题时，可将该属性设置为 false	boolean	_	true
    String automatic_dropdown() default "";//	对于不可搜索的 Select，是否在输入框获得焦点后自动弹出选项菜单	boolean	_	false
    String tag() default "el-select";

    class Option {
        public Option(String value, String label, boolean disabled) {
            this.value = value;
            this.label = label;
            this.disabled = disabled;
        }

        public Option(String value, String label) {
            this.value = value;
            this.label = label;
            this.disabled = false;
        }

        private String value;//	选项的值	string/number/object	—	—
        private String label;//	选项的标签，若不设置则默认与 value 相同	string/number	—	—
        private boolean disabled;//	是否禁用该选项	boolean	—	false

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }
    }
}
