package demo.view;

import demo.controller.PermissionController;
import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.plus.element.annotation.Login;
import org.december.beanui.plus.element.annotation.Logout;
import org.december.beanui.plus.element.annotation.Userinfo;

@Userinfo(rest = PermissionController.class, func = "info")
@Logout(rest = PermissionController.class, func = "logout")
@Login(rest = PermissionController.class, func = "login")
public class LoginComponent {
    @I18N(en = "BEANUI SIGNIN", zh_CN = "BEANUI SIGNIN")
    @Login.Title
    private String title;
    @I18N(en = "Permission name", zh_CN = "用户名")
    @Login.Username
    private String username;
    @I18N(en = "Password", zh_CN = "密 码")
    @Login.Password
    private String password;
    @I18N(en = "Sign in", zh_CN = "登 录")
    @Login.Button
    private String loginButton;
    @I18N(en = "Sign up", zh_CN = "注 册")
    @Login.SignupButton
    private String signupButton;
    @Login.SignupTitle
    private String signupTitle;
    @Login.SignupTips
    private String signupTips;

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

    public String getSignupButton() {
        return signupButton;
    }

    public void setSignupButton(String signupButton) {
        this.signupButton = signupButton;
    }

    public String getSignupTitle() {
        return signupTitle;
    }

    public void setSignupTitle(String signupTitle) {
        this.signupTitle = signupTitle;
    }

    public String getSignupTips() {
        return signupTips;
    }

    public void setSignupTips(String signupTips) {
        this.signupTips = signupTips;
    }
}
