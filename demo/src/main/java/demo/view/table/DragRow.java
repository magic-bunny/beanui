package demo.view.table;

import org.december.beanui.element.annotation.Rate;
import org.december.beanui.element.annotation.TableColum;
import org.december.beanui.element.annotation.Tag;

public class DragRow {
    @TableColum(label = "ID", width = "70")
    private String id;
    @TableColum(label = "Date", width = "200")
    private String date;
    @TableColum(label = "Title" , width = "400")
    private String title;
    @TableColum(label = "Author", width = "100")
    private String author;
    @Rate
    @TableColum(label = "Importance", width = "200")
    private int importance;
    @TableColum(label = "Readings", width = "100")
    private int readings;
    @Tag
    @TableColum(label = "Status", width = "110")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getReadings() {
        return readings;
    }

    public void setReadings(int readings) {
        this.readings = readings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
