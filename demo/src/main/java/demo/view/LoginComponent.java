package demo.view;

import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.plus.element.annotation.Login;

@Login
public class LoginComponent {
    @I18N(en = "BEANUI SIGNIN", zh_CN = "BEANUI SIGNIN")
    @Login.Title
    private String title;
    @I18N(en = "User name", zh_CN = "用户名")
    @Login.Username
    private String username;
    @I18N(en = "Password", zh_CN = "密 码")
    @Login.Password
    private String password;
    @I18N(en = "Signin", zh_CN = "登 录")
    @Login.Button
    private String loginButton;
    @I18N(en = "Signin(3RD)", zh_CN = "登录（三方）")
    @Login.ThirdpartyButton
    private String thridpartyButton;
    @Login.ThirdpartyTitle
    private String thridpartyTitle;
    @Login.ThirdpartyTips
    private String thridpartyTips;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(String loginButton) {
        this.loginButton = loginButton;
    }

    public String getThridpartyButton() {
        return thridpartyButton;
    }

    public void setThridpartyButton(String thridpartyButton) {
        this.thridpartyButton = thridpartyButton;
    }

    public String getThridpartyTitle() {
        return thridpartyTitle;
    }

    public void setThridpartyTitle(String thridpartyTitle) {
        this.thridpartyTitle = thridpartyTitle;
    }

    public String getThridpartyTips() {
        return thridpartyTips;
    }

    public void setThridpartyTips(String thridpartyTips) {
        this.thridpartyTips = thridpartyTips;
    }
}
