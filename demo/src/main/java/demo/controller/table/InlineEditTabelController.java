package demo.controller.table;

import demo.view.InlineEditTableComponent;
import demo.view.table.InlineEditRow;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inline-edit-table")
public class InlineEditTabelController {
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public InlineEditTableComponent init() {
        InlineEditTableComponent inlineEditTableComponent = new InlineEditTableComponent();
        List<InlineEditRow> tableData = new ArrayList<InlineEditRow>();

        InlineEditRow inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("1");
        inlineEditRow.setDate("2013-11-21 10:24");
        inlineEditRow.setTitle("Ulcycm Btktiti Nvssyf Utlpwph Dpvhlhftv Vksoo Bssyduiu Ojryewq");
        inlineEditRow.setAuthor("Jeffrey");
        inlineEditRow.setImportance(3);
        inlineEditRow.setReadings(3788);
        inlineEditRow.setStatus("deleted");
        inlineEditRow.setAction("1");
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("1");
        inlineEditRow.setDate("1987-12-25 16:33");
        inlineEditRow.setTitle("Axnzqhehl Ldtjxdol Qxownrydo Jrdsqoyau Eonlhk");
        inlineEditRow.setAuthor("William");
        inlineEditRow.setReadings(2264);
        inlineEditRow.setStatus("draft");
        inlineEditRow.setImportance(1);
        inlineEditRow.setAction("1");
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setImportance(1);
        inlineEditRow.setId("2");
        inlineEditRow.setDate("2007-06-05 05:59");
        inlineEditRow.setTitle("Xkgebkwj Vscaedii Lmjrhna Dsht Pokxn Rczgc");
        inlineEditRow.setAuthor("William");
        inlineEditRow.setReadings(3712);
        inlineEditRow.setStatus("draft");
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setImportance(2);
        inlineEditRow.setId("3");
        inlineEditRow.setDate("1977-07-11 11:17");
        inlineEditRow.setTitle("Djjh Tunw Jqxk Evht Sdltrab Vumox Uqdfvt");
        inlineEditRow.setAuthor("Steven");
        inlineEditRow.setReadings(2078);
        inlineEditRow.setStatus("published");
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setImportance(4);
        inlineEditRow.setId("4");
        inlineEditRow.setDate("1971-08-30 09:40");
        inlineEditRow.setTitle("Ezkj Efkqcyv Vmhv Sbtzxcfmv Ztwbeczpg Fwm");
        inlineEditRow.setAuthor("Scott");
        inlineEditRow.setReadings(4194);
        inlineEditRow.setStatus("draft");
        inlineEditRow.setImportance(1);
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("5");
        inlineEditRow.setDate("1985-04-05 09:16");
        inlineEditRow.setTitle("Oeojqizd Ssoivufs Ostvtdqr Wgsscb Pbxyfrwq");
        inlineEditRow.setAuthor("Elizabeth");
        inlineEditRow.setReadings(1620);
        inlineEditRow.setStatus("draft");
        inlineEditRow.setImportance(2);
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("6");
        inlineEditRow.setDate("1997-01-24 04:49");
        inlineEditRow.setTitle("Kekizewghb Sngorv Gmlxneg Vzlyetuc Fmanyepm Ggcuiuok");
        inlineEditRow.setAuthor("Robert");
        inlineEditRow.setReadings(2565);
        inlineEditRow.setStatus("published");
        inlineEditRow.setImportance(1);
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("7");
        inlineEditRow.setDate("2016-03-01 12:32");
        inlineEditRow.setTitle("Exohuw Yqmu Lqcxqzcx Vkyjui Dryakkn Rczbfh Sshf Ntbklto Qounhwjg");
        inlineEditRow.setAuthor("Thomas");
        inlineEditRow.setReadings(3080);
        inlineEditRow.setStatus("published");
        inlineEditRow.setImportance(5);
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("8");
        inlineEditRow.setDate("1983-06-22 01:18");
        inlineEditRow.setTitle("Daf Sqvf Jtusdk Inq Hoiptyu Oibxzjd");
        inlineEditRow.setAuthor("Sarah");
        inlineEditRow.setReadings(3964);
        inlineEditRow.setStatus("deleted");
        inlineEditRow.setImportance(3);
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("9");
        inlineEditRow.setDate("1996-06-06 08:17");
        inlineEditRow.setTitle("Gbhmmqtd Kufwjwc Eggv Ueuamyq Mqwkmsejy");
        inlineEditRow.setAuthor("Michelle");
        inlineEditRow.setReadings(4339);
        inlineEditRow.setStatus("published");
        inlineEditRow.setImportance(1);
        tableData.add(inlineEditRow);

        inlineEditRow = new InlineEditRow();
        inlineEditRow.setId("10");
        inlineEditRow.setDate("2001-11-06 23:31");
        inlineEditRow.setTitle("Klhpoius Lrsodzaw Tnrvio Ggfjkvb Afansgeqp Uvkbaxbyg Tzphjxwg");
        inlineEditRow.setAuthor("Donna");
        inlineEditRow.setReadings(1911);
        inlineEditRow.setStatus("deleted");
        inlineEditRow.setImportance(5);
        tableData.add(inlineEditRow);

        inlineEditTableComponent.setTableData(tableData);
        return inlineEditTableComponent;
    }
}
