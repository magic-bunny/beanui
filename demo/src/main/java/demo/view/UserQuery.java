package demo.view;

import demo.controller.TestFormController;
import org.december.beanui.element.Type;
import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.Button;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Table;
import org.december.beanui.event.annotation.Click;

import java.util.List;

@Form
public class UserQuery {
    @Table(data = "$users")
    private User user;

    private List<User> users;

    @Click(rest = TestFormController.class, func = "test2")
    @Button(text = "query", type = Type.PRIMARY, icon = Icon.SEARCH)
    private String button;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
