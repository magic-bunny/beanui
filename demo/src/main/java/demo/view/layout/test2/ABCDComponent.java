package demo.view.layout.test;

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
