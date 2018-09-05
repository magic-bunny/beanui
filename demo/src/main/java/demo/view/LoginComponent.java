package demo.view;

import org.december.beanui.element.annotation.Component;

@Component
public class LoginComponent {
    private LoginForm loginForm;

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }
}
