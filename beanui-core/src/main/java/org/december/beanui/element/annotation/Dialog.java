package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Dialog {
    String visible() default "";//	是否显示 Dialog，支持 .sync 修饰符	boolean	—	false
    String title() default "";//	Dialog 的标题，也可通过具名 slot （见下表）传入	string	—	—
    String width() default "";//	Dialog 的宽度	string	—	50%
    String fullscreen() default "";//	是否为全屏 Dialog	boolean	—	false
    String top() default "";//	Dialog CSS 中的 margin_top 值	string	—	15vh
    String modal() default "";//	是否需要遮罩层	boolean	—	true
    String modal_append_to_body() default "";//	遮罩层是否插入至 body 元素上，若为 false，则遮罩层会插入至 Dialog 的父元素上	boolean	—	true
    String append_to_body() default "";//	Dialog 自身是否插入至 body 元素上。嵌套的 Dialog 必须指定该属性并赋值为 true	boolean	—	false
    String lock_scroll() default "";//	是否在 Dialog 出现时将 body 滚动锁定	boolean	—	true
    String custom_class() default "";//	Dialog 的自定义类名	string	—	—
    String close_on_click_modal() default "";//	是否可以通过点击 modal 关闭 Dialog	boolean	—	true
    String close_on_press_escape() default "";//	是否可以通过按下 ESC 关闭 Dialog	boolean	—	true
    String show_close() default "";//	是否显示关闭按钮	boolean	—	true
    String before_close() default "";//	关闭前的回调，会暂停 Dialog 的关闭	function(done)，done 用于关闭 Dialog	—	—
    String center() default "";//	是否对头部和底部采用居中布局	boolean	—	false
    String tag() default "el-dialog";
}
