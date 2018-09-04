package demo.view;

import org.december.beanui.element.annotation.*;
import org.december.beanui.element.Size;

import java.util.Date;

@Table
public class User {
    @TableColum(type = "selection", width = "50")
    private int id;
    @TableColum
    @Input(size = Size.MINI)
    private String name;
    @TableColum
    @InputNumber(size = Size.MINI)
    private int age;
    @TableColum
    private int stature;
    @TableColum
    @InputNumber(size = Size.MINI)
    private int weight;
    @TableColum(width = "240")
    @DatePicker(size = Size.MINI)
    private Date lastDate;
    @TableColum(label = "edit")
    @Button(text = "edit", size = Size.MINI)
    private String option;

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
