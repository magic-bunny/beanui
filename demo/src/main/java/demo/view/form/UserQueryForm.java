package demo.view.form;

import demo.controller.TestFormController;
import demo.view.table.UserRow;
import org.december.beanui.element.Type;
import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.Button;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Table;
import org.december.beanui.event.annotation.Click;

import java.util.List;

@Form
public class UserQueryForm {
    @Table(data = "$users")
    private UserRow user;

    private List<UserRow> users;

    @Click(rest = TestFormController.class, func = "test2")
    @Button(text = "query", type = Type.PRIMARY, icon = Icon.SEARCH)
    private String button;

    public List<UserRow> getUsers() {
        return users;
    }

    public void setUsers(List<UserRow> users) {
        this.users = users;
    }

    public UserRow getUser() {
        return user;
    }

    public void setUser(UserRow user) {
        this.user = user;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
