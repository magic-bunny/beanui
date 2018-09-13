package demo.view;

import demo.view.form.ComplexTableDataForm;
import demo.view.form.ComplexTableEditForm;
import org.december.beanui.element.annotation.Component;

@Component
public class ComplexTableComponent {
    private ComplexTableDataForm complexTableDataForm;

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
