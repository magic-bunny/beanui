package demo.view.home;

import demo.controller.home.DashboardController;
import org.december.beanui.chart.annotation.LineChart;
import org.december.beanui.chart.annotation.RadarChart;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.event.annotation.Created;

@Form
@Created(rest = DashboardController.class, func = "test2")
public class ChartForm2 {
    @RadarChart(indicator = "[{ name: '销售（sales）', max: 6500},{ name: '管理（Administration）', max: 16000, color: 'red'},{ name: '信息技术（Information Techology）', max: 30000},{ name: '客服（Customer Support）', max: 38000},{ name: '研发（Development）', max: 52000},{ name: '市场（Marketing）', max: 25000}]")
    private Chart2 chart2;

    public Chart2 getChart2() {
        return chart2;
    }

    public void setChart2(Chart2 chart2) {
        this.chart2 = chart2;
    }
}
