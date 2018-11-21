package demo.view.home;

import demo.controller.home.DashboardController;
import org.december.beanui.chart.annotation.LineChart;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.event.annotation.Created;

@Form
@Created(rest = DashboardController.class, func = "card")
public class ChartForm1 {
    @LineChart
    private Chart1 chart1;

    public Chart1 getChart1() {
        return chart1;
    }

    public void setChart1(Chart1 chart1) {
        this.chart1 = chart1;
    }
}
