package demo.view;

import demo.view.form.UserQueryForm;
import org.december.beanui.element.annotation.Component;

@Component
public class ABCDComponent {
    private UserQueryForm userQuery;

    public UserQueryForm getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(UserQueryForm userQuery) {
        this.userQuery = userQuery;
    }
}
