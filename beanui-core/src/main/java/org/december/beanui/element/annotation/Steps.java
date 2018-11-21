package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Steps {
    String space() default "";//	每个 step 的间距，不填写将自适应间距。支持百分比。	number / string	—	—
    String direction() default "";//	显示方向	string	vertical/horizontal	horizontal
    String active() default "";//	设置当前激活步骤	number	—	0
    String process_status() default "";//	设置当前步骤的状态	string	wait / process / finish / error / success	process
    String finish_status() default "";//	设置结束步骤的状态	string	wait / process / finish / error / success	finish
    String align_center() default "";//	进行居中对齐	boolean	_	false
    String simple() default "";//	是否应用简洁风格	boolean	_	false
    String tag() default "el-steps";
    String v_model() default "";

    class Step {
        class Status {
            private Status() {
            }

            public static final String WAIT = "wait";
            public static final String PROCESS = "process";
            public static final String FINISH = "finish";
            public static final String ERROR = "error";
            public static final String SUCCESS = "success";
        }

        public Step(String title, String description, String icon, String status) {
            this.title = title;
            this.description = description;
            this.icon = icon;
            this.status = status;
        }

        public Step(String title) {
            this.title = title;
        }

        private String title;//	标题	string	—	—
        private String description;//	描述性文字	string	—	—
        private String icon;//	图标	传入 icon 的 class 全名来自定义 icon，也支持 slot 方式写入	string	—
        private String status;//	设置当前步骤的状态，不设置则根据 steps 确定状态	wait / process / finish / error / success	-

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
