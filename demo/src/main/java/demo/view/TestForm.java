package demo.view;

import demo.controller.TestFormController;
import org.december.beanui.element.ButtonType;
import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;
import org.december.beanui.event.annotation.Created;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Created(rest = TestFormController.class, func="test3")
@Form
public class TestForm {
    @Input
    private String username;

    @Input
    private String password;

    @Switch
    private boolean isAdmin;

    @DatePicker
    private Date lastDate;

    @Table()
    private List<User> users;

    @Rate
    private int level;

    @Select(placeholder = "请选择", optionId = "options")
    private String detail;

    @Option
    private List<Map<String, String>> options;

    @FormItem(prop = "test")
    @Click(rest = TestFormController.class, func = "test3")
    @Button(text = "upload", type = ButtonType.PRIMARY, icon = Icon.UPLOAD)
    private String button;

    @FormItem(prop = "test")
    @Button(text = "clear")
    private String button2;

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

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getButton2() {
        return button2;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Map<String, String>> getOptions() {
        return options;
    }

    public void setOptions(List<Map<String, String>> options) {
        this.options = options;
    }
}
