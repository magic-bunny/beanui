package demo.view.message;

import org.december.beanui.i18n.annotation.I18N;

public class UserQueryFormMessage {

    @I18N(en = "Update successful!", zh_CN = "修改成功！")
    private String message;
    @I18N(en = "continue?", zh_CN = "是否需要修改？")
    private String confirmMessage;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getConfirmMessage() {
        return confirmMessage;
    }

    public void setConfirmMessage(String confirmMessage) {
        this.confirmMessage = confirmMessage;
    }
}
