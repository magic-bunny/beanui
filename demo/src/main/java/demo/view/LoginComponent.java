package demo.view;

import org.december.beanui.element.Background;
import org.december.beanui.element.Icon;
import org.december.beanui.element.Type;
import org.december.beanui.element.Width;
import org.december.beanui.element.annotation.Button;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Input;

@Component(width = Width.MIDDLE, background = Background.DARK, center = "true")
@Form
public class LoginComponent {
    @Input(label = " ", auto_complete = "on", prefix_icon = Icon.MESSAGE)
    private String username;
    @Input(label = " ", auto_complete = "on", prefix_icon = Icon.GOODS, suffix_icon = Icon.MORE, type="password")
    private String password;
    @Button(text = "login", type = Type.PRIMARY, style="width:100%;margin-bottom:30px;")
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
