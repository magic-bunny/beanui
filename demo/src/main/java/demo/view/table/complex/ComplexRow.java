package demo.view.table.complex;

import demo.controller.table.ComplexTabelController;
import org.december.beanui.element.Size;
import org.december.beanui.element.Type;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;

public class ComplexRow {
    @TableColum(label = "ID", width = "60")
    private String id;
    @TableColum(label = "Date", width = "150")
    private String date;
    @TableColum(label = "Author", width = "100")
    private String author;
    @Rate
    @TableColum(label = "Importance", width = "150")
    private int importance;
    @Click(rest = ComplexTabelController.class, func = "initComplexTableEditForm", responseForm = "$complexTableEditForm")
    @TableColum(label = "Readings", width = "100")
    private int readings;
    @TableColum(label = "Title" , width = "300", prop = "title")
    @Input(size = Size.MINI)
    private String title;
    @Tag(type = "$statusType")
    @TableColum(label = "Status", width = "100")
    private String status;
    private String statusType;
    @Click(rest = ComplexTabelController.class, func = "initComplexTableEditForm", responseForm = "$complexTableEditForm")
    @TableColum(label = "actions", width = "240", prop = "actions")
    @Button(size = Size.MINI, type = Type.PRIMARY, style = "position: absolute;left: 0px;top: 10px;")
    private String actionEdit = "Edit";

    @TableColum(label = "actions", width = "240", prop = "actions")
    @Button(size = Size.MINI, type = Type.SUCCESS, style = "position: absolute;left: 60px;top: 10px;")
    private String actionPublish = "Publish";

    @TableColum(label = "actions", width = "240", prop = "actions")
    @Button(size = Size.MINI, type = Type.DANGER, style = "position: absolute;left: 150px;top: 10px;")
    private String actionDelete = "Delete";

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

    public String getActionEdit() {
        return actionEdit;
    }

    public void setActionEdit(String actionEdit) {
        this.actionEdit = actionEdit;
    }

    public String getActionPublish() {
        return actionPublish;
    }

    public void setActionPublish(String actionPublish) {
        this.actionPublish = actionPublish;
    }

    public String getActionDelete() {
        return actionDelete;
    }

    public void setActionDelete(String actionDelete) {
        this.actionDelete = actionDelete;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }
}
