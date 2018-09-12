package demo.view.table;

import org.december.beanui.element.Icon;
import org.december.beanui.element.Size;
import org.december.beanui.element.Type;
import org.december.beanui.element.annotation.*;

public class InlineEditRow {
    @TableColum(label = "ID", width = "60")
    private String id;
    @TableColum(label = "Date", width = "150")
    private String date;
    @TableColum(label = "Author", width = "100")
    private String author;
    @Rate
    @TableColum(label = "Importance", width = "150")
    private int importance;
    @TableColum(label = "Readings", width = "100")
    private int readings;
    @TableColum(label = "Title" , width = "400", prop = "title")
    @Input(size = Size.MINI, style="padding-right: 100px;")
    private String title;
    @TableColum(width = "120", prop = "title")
    @Button(text = "cancel", icon = Icon.REFRESH, size = Size.MINI, type = Type.WARNING, style = "position: absolute;right: 15px;top: 10px;")
    private String cancel;
    @Tag
    @TableColum(label = "Status", width = "100")
    private String status;
    @TableColum(label = "actions", width = "150")
    @Button(text = "Edit", icon = Icon.EDIT, size = Size.MINI, type = Type.PRIMARY)
    private String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }
}
