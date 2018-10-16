package demo.controller.table;

import demo.view.table.drag.DragTableComponent;
import demo.view.table.drag.DragRow;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drag-table")
public class DragTabelController {
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public DragTableComponent init() {
        DragTableComponent dragTableComponent = new DragTableComponent();
        List<DragRow> tableData = new ArrayList<DragRow>();

        DragRow dragRow = new DragRow();
        dragRow.setId("1");
        dragRow.setDate("2013-11-21 10:24");
        dragRow.setTitle("Ulcycm Btktiti Nvssyf Utlpwph Dpvhlhftv Vksoo Bssyduiu Ojryewq");
        dragRow.setAuthor("Jeffrey");
        dragRow.setImportance(3);
        dragRow.setReadings(3788);
        dragRow.setStatus("deleted");
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setId("1");
        dragRow.setDate("1987-12-25 16:33");
        dragRow.setTitle("Axnzqhehl Ldtjxdol Qxownrydo Jrdsqoyau Eonlhk");
        dragRow.setAuthor("William");
        dragRow.setReadings(2264);
        dragRow.setStatus("draft");
        dragRow.setImportance(1);
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setImportance(1);
        dragRow.setId("2");
        dragRow.setDate("2007-06-05 05:59");
        dragRow.setTitle("Xkgebkwj Vscaedii Lmjrhna Dsht Pokxn Rczgc");
        dragRow.setAuthor("William");
        dragRow.setReadings(3712);
        dragRow.setStatus("draft");
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setImportance(2);
        dragRow.setId("3");
        dragRow.setDate("1977-07-11 11:17");
        dragRow.setTitle("Djjh Tunw Jqxk Evht Sdltrab Vumox Uqdfvt");
        dragRow.setAuthor("Steven");
        dragRow.setReadings(2078);
        dragRow.setStatus("published");
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setImportance(4);
        dragRow.setId("4");
        dragRow.setDate("1971-08-30 09:40");
        dragRow.setTitle("Ezkj Efkqcyv Vmhv Sbtzxcfmv Ztwbeczpg Fwm");
        dragRow.setAuthor("Scott");
        dragRow.setReadings(4194);
        dragRow.setStatus("draft");
        dragRow.setImportance(1);
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setId("5");
        dragRow.setDate("1985-04-05 09:16");
        dragRow.setTitle("Oeojqizd Ssoivufs Ostvtdqr Wgsscb Pbxyfrwq");
        dragRow.setAuthor("Elizabeth");
        dragRow.setReadings(1620);
        dragRow.setStatus("draft");
        dragRow.setImportance(2);
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setId("6");
        dragRow.setDate("1997-01-24 04:49");
        dragRow.setTitle("Kekizewghb Sngorv Gmlxneg Vzlyetuc Fmanyepm Ggcuiuok");
        dragRow.setAuthor("Robert");
        dragRow.setReadings(2565);
        dragRow.setStatus("published");
        dragRow.setImportance(1);
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setId("7");
        dragRow.setDate("2016-03-01 12:32");
        dragRow.setTitle("Exohuw Yqmu Lqcxqzcx Vkyjui Dryakkn Rczbfh Sshf Ntbklto Qounhwjg");
        dragRow.setAuthor("Thomas");
        dragRow.setReadings(3080);
        dragRow.setStatus("published");
        dragRow.setImportance(5);
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setId("8");
        dragRow.setDate("1983-06-22 01:18");
        dragRow.setTitle("Daf Sqvf Jtusdk Inq Hoiptyu Oibxzjd");
        dragRow.setAuthor("Sarah");
        dragRow.setReadings(3964);
        dragRow.setStatus("deleted");
        dragRow.setImportance(3);
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setId("9");
        dragRow.setDate("1996-06-06 08:17");
        dragRow.setTitle("Gbhmmqtd Kufwjwc Eggv Ueuamyq Mqwkmsejy");
        dragRow.setAuthor("Michelle");
        dragRow.setReadings(4339);
        dragRow.setStatus("published");
        dragRow.setImportance(1);
        tableData.add(dragRow);

        dragRow = new DragRow();
        dragRow.setId("10");
        dragRow.setDate("2001-11-06 23:31");
        dragRow.setTitle("Klhpoius Lrsodzaw Tnrvio Ggfjkvb Afansgeqp Uvkbaxbyg Tzphjxwg");
        dragRow.setAuthor("Donna");
        dragRow.setReadings(1911);
        dragRow.setStatus("deleted");
        dragRow.setImportance(5);
        tableData.add(dragRow);

        dragTableComponent.setTableData(tableData);
        return dragTableComponent;
    }
}
