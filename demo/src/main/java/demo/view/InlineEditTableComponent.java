package demo.view;

import demo.controller.table.InlineEditTabelController;
import demo.view.table.InlineEditRow;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Table;
import org.december.beanui.event.annotation.Created;

import java.util.List;

@Created(rest = InlineEditTabelController.class, func = "init")
@Component
@Form
public class InlineEditTableComponent {
    @Table(data = "$tableData", highlight_current_row = "true")
    private InlineEditRow table;

    private List<InlineEditRow> tableData;

    public InlineEditRow getTable() {
        return table;
    }

    public void setTable(InlineEditRow table) {
        this.table = table;
    }

    public List<InlineEditRow> getTableData() {
        return tableData;
    }

    public void setTableData(List<InlineEditRow> tableData) {
        this.tableData = tableData;
    }
}
