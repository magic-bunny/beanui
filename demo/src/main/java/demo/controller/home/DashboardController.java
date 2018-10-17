package demo.controller.home;

import demo.view.home.*;
import org.december.beanui.chart.KV;
import org.december.beanui.element.Type;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("dashboard")
@RestController
public class DashboardController {

    @RequestMapping(value = "/init_form1", method = RequestMethod.GET)
    public ChartForm1 test1() {
        ChartForm1 chartForm1 = new ChartForm1();
        Chart1 chart1 = new Chart1();
        int[] line1 = {100, 120, 161, 134, 105, 160, 165};
        int[] line2 = {120, 82, 91, 154, 162, 140, 145};
        chart1.setLine1(line1);
        chart1.setLine2(line2);
        chartForm1.setChart1(chart1);
        return chartForm1;
    }

    @RequestMapping(value = "/init_form2", method = RequestMethod.GET)
    public ChartForm2 test2() {
        ChartForm2 chartForm2 = new ChartForm2();
        Chart2 chart2 = new Chart2();
        int[] data1 = {4300, 10000, 28000, 35000, 50000, 19000};
        int[] data2 = {5000, 14000, 28000, 31000, 42000, 21000};
        KV[] kvs = {new KV("预算分配（Allocated Budget）", data1), new KV("实际开销（Actual Spending）", data2)};
        chart2.setData1(kvs);
        chartForm2.setChart2(chart2);
        return chartForm2;
    }

    @RequestMapping(value = "/init_form3", method = RequestMethod.GET)
    public ChartForm3 test3() {
        ChartForm3 chartForm3 = new ChartForm3();
        Chart3 chart3 = new Chart3();
        KV[] kvs = {
                new KV("直接访问", 335),
                new KV("邮件营销", 310),
                new KV("联盟广告", 274),
                new KV("视频广告", 235),
                new KV("搜索引擎", 400)
        };
        chart3.setData1(kvs);
        chartForm3.setChart3(chart3);
        return chartForm3;
    }

    @RequestMapping(value = "/init_form4", method = RequestMethod.GET)
    public ChartForm4 test4() {
        ChartForm4 chartForm4 = new ChartForm4();
        Chart4 chart4 = new Chart4();
        int[] data1 = {320, 332, 301, 334, 390};
        int[] data2 = {220, 182, 191, 234, 290};
        int[] data3 = {150, 232, 201, 154, 190};
        int[] data4 = {98, 77, 101, 99, 40};
        chart4.setData1(data1);
        chart4.setData2(data2);
        chart4.setData3(data3);
        chart4.setData4(data4);
        chartForm4.setChart4(chart4);
        return chartForm4;
    }

    @RequestMapping(value = "/init_form5", method = RequestMethod.GET)
    public TableForm test5() {
        TableForm tableForm = new TableForm();
        List<TableRow> tableRows = new ArrayList<TableRow>();
        TableRow tableRow = new TableRow();
        tableRow.setOrderNumber("fe5BF8Ed-BF8e-A26d-25EB-Fb6716");
        tableRow.setCurrency("USD");
        tableRow.setPrice(14184.7);
        tableRow.setSuccess(Type.DANGER);
        tableRow.setStatus("pending");
        tableRows.add(tableRow);

        tableRow = new TableRow();
        tableRow.setOrderNumber("768c7bde-4a53-3A0F-c4c1-5A3bc8");
        tableRow.setPrice(6490.4);
        tableRow.setCurrency("USD");
        tableRow.setStatus("pending");
        tableRow.setSuccess(Type.DANGER);
        tableRows.add(tableRow);

        tableRow = new TableRow();
        tableRow.setOrderNumber("9b4FFd6C-be65-eD4F-cE25-3B4aE7");
        tableRow.setPrice(12683);
        tableRow.setCurrency("USD");
        tableRow.setStatus("pending");
        tableRow.setSuccess(Type.DANGER);
        tableRows.add(tableRow);

        tableRow = new TableRow();
        tableRow.setOrderNumber("97b2BEF7-1A83-ee46-d994-6f45cC");
        tableRow.setPrice(8778.5);
        tableRow.setCurrency("CNY");
        tableRow.setStatus("success");
        tableRow.setSuccess(Type.SUCCESS);
        tableRows.add(tableRow);

        tableRow = new TableRow();
        tableRow.setOrderNumber("B3afCE5B-6B9e-3fe5-9Aff-8bb23F");
        tableRow.setPrice(13338.3);
        tableRow.setCurrency("CNY");
        tableRow.setStatus("success");
        tableRow.setSuccess(Type.SUCCESS);
        tableRows.add(tableRow);

        tableRow = new TableRow();
        tableRow.setOrderNumber("b9cAF87F-04FB-6C6F-159b-3ceD9d");
        tableRow.setPrice(9919.47);
        tableRow.setCurrency("USD");
        tableRow.setStatus("pending");
        tableRow.setSuccess(Type.DANGER);
        tableRows.add(tableRow);

        tableRow = new TableRow();
        tableRow.setOrderNumber("ef69AEf0-A2dA-b9d1-DF77-Af7F0B");
        tableRow.setPrice(2520);
        tableRow.setCurrency("CNY");
        tableRow.setStatus("success");
        tableRow.setSuccess(Type.SUCCESS);
        tableRows.add(tableRow);

        tableRow = new TableRow();
        tableRow.setOrderNumber("B8f3e3FD-2b13-ECC9-5084-9c7B88");
        tableRow.setPrice(14984);
        tableRow.setCurrency("CNY");
        tableRow.setStatus("success");
        tableRow.setSuccess(Type.SUCCESS);
        tableRows.add(tableRow);

        tableForm.setTabelRowData(tableRows);

        return tableForm;
    }
}
