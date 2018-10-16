package demo.view.table.complex;

import demo.controller.table.ComplexTabelController;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Table;
import org.december.beanui.event.annotation.Created;

import java.util.List;

@Created(rest = ComplexTabelController.class, func = "initComplexTableDataForm")
@Form
public class ComplexTableDataForm {
    @Table(data = "$tableData")
    private ComplexRow table;

    private List<ComplexRow> tableData;

    public ComplexRow getTable() {
        return table;
    }

    public void setTable(ComplexRow table) {
        this.table = table;
    }

    public List<ComplexRow> getTableData() {
        return tableData;
    }

    public void setTableData(List<ComplexRow> tableData) {
        this.tableData = tableData;
    }
}
