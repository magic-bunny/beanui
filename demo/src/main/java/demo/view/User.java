package demo.view;

import org.december.beanui.element.annotation.Button;
import org.december.beanui.element.annotation.Table;
import org.december.beanui.element.annotation.TableColum;

import java.util.Date;

@Table
public class User {
    @TableColum
    private int id;
    @TableColum
    private String name;
    @TableColum
    private int age;
    @TableColum
    private int stature;
    @TableColum
    private int weight;
    @TableColum
    private Date lastDate;
    @TableColum(label = "edit")
    @Button(text = "edit")
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
