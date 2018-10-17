package demo.view.home;

import demo.controller.home.DashboardController;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Table;
import org.december.beanui.event.annotation.Created;

import java.util.List;

@Created(rest = DashboardController.class, func = "test5")
@Form
public class TableForm {

    @Table(data = "$tabelRowData")
    private TableRow tableRow;

    private List<TableRow> tabelRowData;

    public List<TableRow> getTabelRowData() {
        return tabelRowData;
    }

    public void setTabelRowData(List<TableRow> tabelRowData) {
        this.tabelRowData = tabelRowData;
    }

    public TableRow getTableRow() {
        return tableRow;
    }

    public void setTableRow(TableRow tableRow) {
        this.tableRow = tableRow;
    }
}
