package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Dropdown {
    String type() default "";//	菜单按钮类型，同 Button 组件(只在split_button为 true 的情况下有效)	string	—	—
    String size() default "";//	菜单尺寸，在split_button为 true 的情况下也对触发按钮生效	string	medium / small / mini	—
    String split_button() default "";//	下拉触发元素呈现为按钮组	boolean	—	false
    String placement() default "";//	菜单弹出位置	string	top/top_start/top_end/bottom/bottom_start/bottom_end	bottom_end
    String trigger() default "";//	触发下拉的行为	string	hover, click	hover
    String hide_on_click() default "";//	是否在点击菜单项后隐藏菜单	boolean	—	true
    String show_timeout() default "";//	展开下拉菜单的延时（仅在 trigger 为 hover 时有效）	number	—	250
    String hide_timeout() default "";//	收起下拉菜单的延时（仅在 trigger 为 hover 时有效）	number	—	150
    String data() default "";
    String tag() default "el-dropdown";
    String v_model() default "";

    class Item {
        public Item(String text) {
            this.text = text;
        }

        private String text;
        private String command;//	指令	string/number/object	—	—
        private boolean disabled;//	禁用	boolean	—	false
        private boolean divided;//	显示分割线	boolean	—	false

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public boolean isDivided() {
            return divided;
        }

        public void setDivided(boolean divided) {
            this.divided = divided;
        }
    }
}
