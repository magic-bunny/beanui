package demo.view;

import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.Button;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Input;

@Form
public class LoginForm {
    @Input(auto_complete = "on", prefix_icon = Icon.MESSAGE)
    private String username;
    @Input(auto_complete = "on", prefix_icon = Icon.GOODS, suffix_icon = Icon.MORE, type="password")
    private String password;
    @Button(text = "login")
    private String loginButoon;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginButoon() {
        return loginButoon;
    }

    public void setLoginButoon(String loginButoon) {
        this.loginButoon = loginButoon;
    }
}
