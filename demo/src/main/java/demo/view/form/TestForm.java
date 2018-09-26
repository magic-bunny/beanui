package demo.view.form;

import demo.controller.TestFormController;
import demo.view.table.UserRow;
import org.december.beanui.element.Type;
import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;
import org.december.beanui.event.annotation.Created;
import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.rule.annotation.Rule;

import java.util.Date;
import java.util.List;

@Created(rest = TestFormController.class, func="test3")
@Form
public class TestForm {
    @Tooltip(content = "请输入6位以上用户名", placement = Tooltip.Placement.RIGHT)
    @Rule(required = "true")
    @I18N(en = "user name", zh_CN = "用户名")
    @Input
    private String username;

    @Rule(required = "true")
    @I18N(en = "password", zh_CN = "密码")
    @Input(type = Input.Type.TEXTAREA)
    private String password;

    @Badge(value = "20")
    @Switch
    private boolean isAdmin;

    @DatePicker
    private Date lastDate;

    @Table()
    private List<UserRow> users;

    private String test;

    @Rate
    private int level;

    @Select(placeholder = "请选择", data = "$options")
    private String detail;

    private List<Select.Option> options;

    @Transfer(titles = ":['1','2']", data = "$addressData")
    private List<String> address;

    private List<Transfer.Data> addressData;

    @FormItem(prop = "test")
    @Click(rest = TestFormController.class, func = "test3")
    @Button(text = "upload", type = Type.PRIMARY, icon = Icon.UPLOAD)
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

    public List<UserRow> getUsers() {
        return users;
    }

    public void setUsers(List<UserRow> users) {
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

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }


    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public List<Select.Option> getOptions() {
        return options;
    }

    public void setOptions(List<Select.Option> options) {
        this.options = options;
    }

    public List<Transfer.Data> getAddressData() {
        return addressData;
    }

    public void setAddressData(List<Transfer.Data> addressData) {
        this.addressData = addressData;
    }
}
