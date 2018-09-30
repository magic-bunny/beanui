package demo.view;

import demo.controller.table.DragTabelController;
import demo.view.table.DragRow;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Table;
import org.december.beanui.event.annotation.Created;

import java.util.List;

@Created(rest = DragTabelController.class, func = "init")
@Component("/drag-tabel")
@Form
public class DragTableComponent {
    @Table(data = "$tableData", highlight_current_row = "true", border = "true", fit = "true")
    private DragRow table;

    private List<DragRow> tableData;

    public DragRow getTable() {
        return table;
    }

    public void setTable(DragRow table) {
        this.table = table;
    }

    public List<DragRow> getTableData() {
        return tableData;
    }

    public void setTableData(List<DragRow> tableData) {
        this.tableData = tableData;
    }
}
