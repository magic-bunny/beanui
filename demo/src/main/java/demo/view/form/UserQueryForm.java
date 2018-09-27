package demo.view.form;

import demo.controller.TestFormController;
import demo.view.table.UserRow;
import org.december.beanui.element.Size;
import org.december.beanui.element.Type;
import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;

import java.util.List;

@Form
public class UserQueryForm {
    @Table(data = "$users")
    private List<UserRow> user;

    private List<UserRow> users;

    @FormItem(prop = "a")
    @Click(rest = TestFormController.class, func = "test2")
    @Button(text = "Query", type = Type.PRIMARY, icon = Icon.SEARCH, size = Size.MINI)
    private String button;

    @FormItem(prop = "a")
    @Click(rest = TestFormController.class, func = "test4", confirmMessage = "$t('demo.view.message.UserQueryFormMessage.confirmMessage')", message = "$t('demo.view.message.UserQueryFormMessage.message')")
    @Button(text = "Save", type = Type.DANGER, icon = Icon.SEARCH)
    private String button2;

    public List<UserRow> getUsers() {
        return users;
    }

    public void setUsers(List<UserRow> users) {
        this.users = users;
    }

    public List<UserRow> getUser() {
        return user;
    }

    public void setUser(List<UserRow> user) {
        this.user = user;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getButton2() {
        return button2;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }
}
