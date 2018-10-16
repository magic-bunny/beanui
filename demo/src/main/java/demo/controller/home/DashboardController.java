package demo.controller.home;

import demo.view.home.*;
import demo.view.test.test1.TestChart;
import demo.view.test.test1.TestForm;
import demo.view.test.test2.UserQueryForm;
import demo.view.test.test2.UserRow;
import org.december.beanui.chart.KV;
import org.december.beanui.element.annotation.Select;
import org.december.beanui.element.annotation.Transfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("dashboard")
@RestController
public class DashboardController {

    @RequestMapping(value="/init_form1",  method = RequestMethod.GET)
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

    @RequestMapping(value="/init_form2",  method = RequestMethod.GET)
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

    @RequestMapping(value="/init_form3",  method = RequestMethod.GET)
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
}
