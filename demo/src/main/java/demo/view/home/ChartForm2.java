package demo.view.home;

import demo.controller.home.DashboardController;
import org.december.beanui.chart.annotation.LineChart;
import org.december.beanui.chart.annotation.RadarChart;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.event.annotation.Created;

@Form
@Created(rest = DashboardController.class, func = "test2")
public class ChartForm2 {
    @RadarChart(indicator = "[{ name: '销售', max: 6500},{ name: '管理', max: 16000, color: 'red'},{ name: '信息技术', max: 30000},{ name: '客服', max: 38000},{ name: '研发', max: 52000},{ name: '市场', max: 25000}]")
    private Chart2 chart2;

    public Chart2 getChart2() {
        return chart2;
    }

    public void setChart2(Chart2 chart2) {
        this.chart2 = chart2;
    }
}
