package demo.view;

import demo.controller.table.DynamicTableController;
import demo.view.table.DynamicRow;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Created;

import java.util.List;
import java.util.Map;

@Created(rest = DynamicTableController.class, func = "init")
@Component("/dynamic-table")
@Form
public class DynamicTableComponent {
    @Alert(title = "Fixed header, sorted by header order")
    private String label1;

    @CheckboxGroup(data = "$checkboxData1")
    private List<String> checkbox1;

    @Table(data = "$tableData1")
    private DynamicRow table1;

    @Alert(title = "Not fixed header, sorted by click order")
    private String label2;

    @CheckboxGroup(data = "$checkboxData2")
    private List<String> checkbox2;

    @Table(data = "$tableData2")
    private DynamicRow table2;

    private List<Map> checkboxData1;

    private List<Map> checkboxData2;

    private List<DynamicRow> tableData1;

    private List<DynamicRow> tableData2;

    public List<String> getCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(List<String> checkbox1) {
        this.checkbox1 = checkbox1;
    }

    public List<Map> getCheckboxData1() {
        return checkboxData1;
    }

    public void setCheckboxData1(List<Map> checkboxData1) {
        this.checkboxData1 = checkboxData1;
    }

    public DynamicRow getTable1() {
        return table1;
    }

    public void setTable1(DynamicRow table1) {
        this.table1 = table1;
    }

    public DynamicRow getTable2() {
        return table2;
    }

    public void setTable2(DynamicRow table2) {
        this.table2 = table2;
    }

    public List<DynamicRow> getTableData1() {
        return tableData1;
    }

    public void setTableData1(List<DynamicRow> tableData1) {
        this.tableData1 = tableData1;
    }

    public List<DynamicRow> getTableData2() {
        return tableData2;
    }

    public void setTableData2(List<DynamicRow> tableData2) {
        this.tableData2 = tableData2;
    }

    public List<String> getCheckbox2() {
        return checkbox2;
    }

    public void setCheckbox2(List<String> checkbox2) {
        this.checkbox2 = checkbox2;
    }

    public List<Map> getCheckboxData2() {
        return checkboxData2;
    }

    public void setCheckboxData2(List<Map> checkboxData2) {
        this.checkboxData2 = checkboxData2;
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }
}
