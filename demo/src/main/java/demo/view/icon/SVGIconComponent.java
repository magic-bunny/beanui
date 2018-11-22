package demo.view.icon;

import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.FormItem;
import org.december.beanui.element.annotation.SVG;

@Component
@Form
public class SVGIconComponent {
    @FormItem(prop = "line1") @SVG(icon_class = "404", style = "margin: 20px;height: 50px; width: 50px;") private String svg404 = "404";
    @FormItem(prop = "line1") @SVG(icon_class = "bug", style = "margin: 20px;height: 50px; width: 50px;") private String bug = "bug";
    @FormItem(prop = "line1") @SVG(icon_class = "chart", style = "margin: 20px;height: 50px; width: 50px;") private String chart = "chart";
    @FormItem(prop = "line1") @SVG(icon_class = "clipboard", style = "margin: 20px;height: 50px; width: 50px;") private String clipboard = "clipboard";
    @FormItem(prop = "line1") @SVG(icon_class = "component", style = "margin: 20px;height: 50px; width: 50px;") private String component = "component";
    @FormItem(prop = "line1") @SVG(icon_class = "dashboard", style = "margin: 20px;height: 50px; width: 50px;") private String dashboard = "dashboard";
    @FormItem(prop = "line2") @SVG(icon_class = "documentation", style = "margin: 20px;height: 50px; width: 50px;") private String documentation = "documentation";
    @FormItem(prop = "line2") @SVG(icon_class = "drag", style = "margin: 20px;height: 50px; width: 50px;") private String drag = "drag";
    @FormItem(prop = "line2") @SVG(icon_class = "edit", style = "margin: 20px;height: 50px; width: 50px;") private String edit = "edit";
    @FormItem(prop = "line2") @SVG(icon_class = "email", style = "margin: 20px;height: 50px; width: 50px;") private String email = "email";
    @FormItem(prop = "line2") @SVG(icon_class = "example", style = "margin: 20px;height: 50px; width: 50px;") private String example = "example";
    @FormItem(prop = "line2") @SVG(icon_class = "excel", style = "margin: 20px;height: 50px; width: 50px;") private String excel = "excel";
    @FormItem(prop = "line3") @SVG(icon_class = "eye", style = "margin: 20px;height: 50px; width: 50px;") private String eye = "eye";
    @FormItem(prop = "line3") @SVG(icon_class = "form", style = "margin: 20px;height: 50px; width: 50px;") private String form = "form";
    @FormItem(prop = "line3") @SVG(icon_class = "guide", style = "margin: 20px;height: 50px; width: 50px;") private String guide = "guide";
    @FormItem(prop = "line3") @SVG(icon_class = "icon", style = "margin: 20px;height: 50px; width: 50px;") private String icon = "icon";
    @FormItem(prop = "line3") @SVG(icon_class = "international", style = "margin: 20px;height: 50px; width: 50px;") private String international = "international";
    @FormItem(prop = "line3") @SVG(icon_class = "language", style = "margin: 20px;height: 50px; width: 50px;") private String language = "language";
    @FormItem(prop = "line4") @SVG(icon_class = "list", style = "margin: 20px;height: 50px; width: 50px;") private String list = "list";
    @FormItem(prop = "line4") @SVG(icon_class = "lock", style = "margin: 20px;height: 50px; width: 50px;") private String lock = "lock";
    @FormItem(prop = "line4") @SVG(icon_class = "message", style = "margin: 20px;height: 50px; width: 50px;") private String message = "message";
    @FormItem(prop = "line4") @SVG(icon_class = "money", style = "margin: 20px;height: 50px; width: 50px;") private String money = "money";
    @FormItem(prop = "line4") @SVG(icon_class = "nested", style = "margin: 20px;height: 50px; width: 50px;") private String nested = "nested";
    @FormItem(prop = "line4") @SVG(icon_class = "password", style = "margin: 20px;height: 50px; width: 50px;") private String password = "password";
    @FormItem(prop = "line5") @SVG(icon_class = "people", style = "margin: 20px;height: 50px; width: 50px;") private String people = "people";
    @FormItem(prop = "line5") @SVG(icon_class = "peoples", style = "margin: 20px;height: 50px; width: 50px;") private String peoples = "peoples";
    @FormItem(prop = "line5") @SVG(icon_class = "qq", style = "margin: 20px;height: 50px; width: 50px;") private String qq = "qq";
    @FormItem(prop = "line5") @SVG(icon_class = "shoppingCard", style = "margin: 20px;height: 50px; width: 50px;") private String shoppingCard = "shoppingCard";
    @FormItem(prop = "line5") @SVG(icon_class = "star", style = "margin: 20px;height: 50px; width: 50px;") private String star = "star";
    @FormItem(prop = "line5") @SVG(icon_class = "tab", style = "margin: 20px;height: 50px; width: 50px;") private String tab = "tab";
    @FormItem(prop = "line6") @SVG(icon_class = "table", style = "margin: 20px;height: 50px; width: 50px;") private String table = "table";
    @FormItem(prop = "line6") @SVG(icon_class = "theme", style = "margin: 20px;height: 50px; width: 50px;") private String theme = "theme";
    @FormItem(prop = "line6") @SVG(icon_class = "user", style = "margin: 20px;height: 50px; width: 50px;") private String user = "user";
    @FormItem(prop = "line6") @SVG(icon_class = "wechat", style = "margin: 20px;height: 50px; width: 50px;") private String wechat = "wechat";
    @FormItem(prop = "line6") @SVG(icon_class = "zip", style = "margin: 20px;height: 50px; width: 50px;") private String zip = "zip";

    public String getSvg404() {
        return svg404;
    }

    public void setSvg404(String svg404) {
        this.svg404 = svg404;
    }

    public String getBug() {
        return bug;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getDashboard() {
        return dashboard;
    }

    public void setDashboard(String dashboard) {
        this.dashboard = dashboard;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getDrag() {
        return drag;
    }

    public void setDrag(String drag) {
        this.drag = drag;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExcel() {
        return excel;
    }

    public void setExcel(String excel) {
        this.excel = excel;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNested() {
        return nested;
    }

    public void setNested(String nested) {
        this.nested = nested;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPeoples() {
        return peoples;
    }

    public void setPeoples(String peoples) {
        this.peoples = peoples;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(String shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
