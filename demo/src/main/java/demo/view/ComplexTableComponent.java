package demo.view;

import demo.view.form.ComplexTableDataForm;
import demo.view.form.ComplexTableEditForm;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Dialog;

@Component("/complex-table")
public class ComplexTableComponent {
    private ComplexTableDataForm complexTableDataForm;

    @Dialog(title = "Edit", visible = "$complexTableEditForm.show")
    private ComplexTableEditForm complexTableEditForm;

    public ComplexTableDataForm getComplexTableDataForm() {
        return complexTableDataForm;
    }

    public void setComplexTableDataForm(ComplexTableDataForm complexTableDataForm) {
        this.complexTableDataForm = complexTableDataForm;
    }

    public ComplexTableEditForm getComplexTableEditForm() {
        return complexTableEditForm;
    }

    public void setComplexTableEditForm(ComplexTableEditForm complexTableEditForm) {
        this.complexTableEditForm = complexTableEditForm;
    }
}
