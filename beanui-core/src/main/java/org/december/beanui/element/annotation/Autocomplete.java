package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Autocomplete {
    String placeholder() default "";//	输入框占位文本	string	—	—
    String disabled() default "";//	禁用	boolean	—	false
    String value_key() default "";//	输入建议对象中用于显示的键名	string	—	value
    String value() default "";//	必填值，输入绑定值	string	—	—
    String debounce() default "";//	获取输入建议的去抖延时	number	—	300
    String placement() default "";//	菜单弹出位置	string	top / top_start / top_end / bottom / bottom_start / bottom_end	bottom_start
    String fetch_suggestions() default "";//	返回输入建议的方法，仅当你的输入建议数据 resolve 时，通过调用 callback(data:[]) 来返回它	Function(queryString, callback)	—	—
    String popper_class() default "";//	Autocomplete 下拉列表的类名	string	—	—
    String trigger_on_focus() default "";//	是否在输入框 focus 时显示建议列表	boolean	—	true
    String name() default "";//	原生属性	string	—	—
    String select_when_unmatched() default "";//	在输入没有任何匹配建议的情况下，按下回车是否触发 select 事件	boolean	—	false
    String label() default "";//	输入框关联的label文字	string	—	—
    String prefix_icon() default "";//	输入框头部图标	string	—	—
    String suffix_icon() default "";//	输入框尾部图标	string	—	—
    String hide_loading() default "";//	是否隐藏远程加载时的加载图标	boolean	—	false
    String popper_append_to_body() default "";//	是否将下拉列表插入至 body 元素。在下拉列表的定位出现问题时，可将该属性设置为 false	boolean	_	true
    String tag() default "el-autocomplete";
}
