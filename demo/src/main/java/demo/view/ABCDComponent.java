package demo.view;

import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Input;

@Component(title = "User Query", path = "menu1", icon = "404", superTitle = "test", superIcon = "lock")
public class ABCDComponent {
    private UserQuery userQuery;

    public UserQuery getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(UserQuery userQuery) {
        this.userQuery = userQuery;
    }
}
