package demo.view.form;

import org.december.beanui.element.annotation.Dialog;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Input;
import org.december.beanui.element.annotation.Rate;

@Form(label_width = "150px")
@Dialog(title = "Edit", visible = "$show")
public class ComplexTableEditForm {
    @Input(label = "Type")
    private String type;
    @Input(label = "Date")
    private String date;
    @Input(label = "Title")
    private String title;
    @Input(label = "Status")
    private String status;
    @Rate(label = "Imp")
    private int imp;
    @Input(label = "Remark")
    private String remark;

    private boolean show = false;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImp() {
        return imp;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
