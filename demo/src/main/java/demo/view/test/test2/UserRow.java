package demo.view.test.test2;

import org.december.beanui.element.annotation.*;
import org.december.beanui.element.Size;
import org.december.beanui.i18n.annotation.I18N;

import java.util.Date;

public class UserRow {
    @TableColum(type = "selection", width = "50")
    private int id;
    @I18N(en = "Name", zh_CN = "姓名")
    @TableColum
    @Input(size = Size.MINI)
    private String name;
    @I18N(en = "Age", zh_CN = "年龄")
    @TableColum
    @InputNumber(size = Size.MINI)
    private int age;
    @I18N(en = "Stature", zh_CN = "身份")
    @TableColum
    private int stature;
    @I18N(en = "Weight", zh_CN = "体重")
    @TableColum
    @InputNumber(size = Size.MINI)
    private int weight;
    @TableColum(width = "240")
    @DatePicker(size = Size.MINI)
    @I18N(en = "Last Edit Date", zh_CN = "修改日期")
    private Date lastDate;
    @I18N(en = "Options", zh_CN = "操作")
    @TableColum(label = "edit")
    @Button(size = Size.MINI)
    private String option = "Edit";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStature() {
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
