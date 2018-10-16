package demo.controller.table;

import demo.view.table.complex.ComplexTableDataForm;
import demo.view.table.complex.ComplexTableEditForm;
import demo.view.table.complex.ComplexRow;
import org.december.beanui.element.Type;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/complex-table")
public class ComplexTabelController {
    @RequestMapping(value = "/init-complex-table-data-form", method = RequestMethod.GET)
    public ComplexTableDataForm initComplexTableDataForm() {
        List<ComplexRow> tableData = new ArrayList<ComplexRow>();

        ComplexRow complexRow = new ComplexRow();
        complexRow.setId("1");
        complexRow.setDate("2013-11-21 10:24");
        complexRow.setTitle("Ulcycm Btktiti Nvssyf Utlpwph Dpvhlhftv Vksoo Bssyduiu Ojryewq");
        complexRow.setAuthor("Jeffrey");
        complexRow.setImportance(3);
        complexRow.setReadings(3788);
        complexRow.setStatus("deleted");
        complexRow.setStatusType(Type.DANGER);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setId("1");
        complexRow.setDate("1987-12-25 16:33");
        complexRow.setTitle("Axnzqhehl Ldtjxdol Qxownrydo Jrdsqoyau Eonlhk");
        complexRow.setAuthor("William");
        complexRow.setReadings(2264);
        complexRow.setStatus("draft");
        complexRow.setStatusType(Type.WARNING);
        complexRow.setImportance(1);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setImportance(1);
        complexRow.setId("2");
        complexRow.setDate("2007-06-05 05:59");
        complexRow.setTitle("Xkgebkwj Vscaedii Lmjrhna Dsht Pokxn Rczgc");
        complexRow.setAuthor("William");
        complexRow.setReadings(3712);
        complexRow.setStatus("draft");
        complexRow.setStatusType(Type.WARNING);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setImportance(2);
        complexRow.setId("3");
        complexRow.setDate("1977-07-11 11:17");
        complexRow.setTitle("Djjh Tunw Jqxk Evht Sdltrab Vumox Uqdfvt");
        complexRow.setAuthor("Steven");
        complexRow.setReadings(2078);
        complexRow.setStatus("published");
        complexRow.setStatusType(Type.SUCCESS);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setImportance(4);
        complexRow.setId("4");
        complexRow.setDate("1971-08-30 09:40");
        complexRow.setTitle("Ezkj Efkqcyv Vmhv Sbtzxcfmv Ztwbeczpg Fwm");
        complexRow.setAuthor("Scott");
        complexRow.setReadings(4194);
        complexRow.setStatus("draft");
        complexRow.setStatusType(Type.WARNING);
        complexRow.setImportance(1);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setId("5");
        complexRow.setDate("1985-04-05 09:16");
        complexRow.setTitle("Oeojqizd Ssoivufs Ostvtdqr Wgsscb Pbxyfrwq");
        complexRow.setAuthor("Elizabeth");
        complexRow.setReadings(1620);
        complexRow.setStatus("draft");
        complexRow.setStatusType(Type.WARNING);
        complexRow.setImportance(2);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setId("6");
        complexRow.setDate("1997-01-24 04:49");
        complexRow.setTitle("Kekizewghb Sngorv Gmlxneg Vzlyetuc Fmanyepm Ggcuiuok");
        complexRow.setAuthor("Robert");
        complexRow.setReadings(2565);
        complexRow.setStatus("published");
        complexRow.setStatusType(Type.SUCCESS);
        complexRow.setImportance(1);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setId("7");
        complexRow.setDate("2016-03-01 12:32");
        complexRow.setTitle("Exohuw Yqmu Lqcxqzcx Vkyjui Dryakkn Rczbfh Sshf Ntbklto Qounhwjg");
        complexRow.setAuthor("Thomas");
        complexRow.setReadings(3080);
        complexRow.setStatus("published");
        complexRow.setStatusType(Type.SUCCESS);
        complexRow.setImportance(5);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setId("8");
        complexRow.setDate("1983-06-22 01:18");
        complexRow.setTitle("Daf Sqvf Jtusdk Inq Hoiptyu Oibxzjd");
        complexRow.setAuthor("Sarah");
        complexRow.setReadings(3964);
        complexRow.setStatus("deleted");
        complexRow.setStatusType(Type.DANGER);
        complexRow.setImportance(3);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setId("9");
        complexRow.setDate("1996-06-06 08:17");
        complexRow.setTitle("Gbhmmqtd Kufwjwc Eggv Ueuamyq Mqwkmsejy");
        complexRow.setAuthor("Michelle");
        complexRow.setReadings(4339);
        complexRow.setStatus("published");
        complexRow.setStatusType(Type.SUCCESS);
        complexRow.setImportance(1);
        tableData.add(complexRow);

        complexRow = new ComplexRow();
        complexRow.setId("10");
        complexRow.setDate("2001-11-06 23:31");
        complexRow.setTitle("Klhpoius Lrsodzaw Tnrvio Ggfjkvb Afansgeqp Uvkbaxbyg Tzphjxwg");
        complexRow.setAuthor("Donna");
        complexRow.setReadings(1911);
        complexRow.setStatus("deleted");
        complexRow.setStatusType(Type.DANGER);
        complexRow.setImportance(5);
        tableData.add(complexRow);

        ComplexTableDataForm complexTableDataForm = new ComplexTableDataForm();
        complexTableDataForm.setTableData(tableData);
        return complexTableDataForm;
    }

    @RequestMapping(value = "/init-complex-table-edit-form", method = RequestMethod.GET)
    public ComplexTableEditForm initComplexTableEditForm() {
        ComplexTableEditForm complexTableEditForm = new ComplexTableEditForm();
        complexTableEditForm.setShow(true);
        return complexTableEditForm;
    }
}
