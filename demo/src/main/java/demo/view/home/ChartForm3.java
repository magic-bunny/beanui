package demo.view.home;

import demo.controller.home.DashboardController;
import org.december.beanui.chart.annotation.PieChart;
import org.december.beanui.chart.annotation.RadarChart;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.event.annotation.Created;

@Form
@Created(rest = DashboardController.class, func = "test3")
public class ChartForm3 {
    @PieChart
    private Chart3 chart3;

    public Chart3 getChart3() {
        return chart3;
    }

    public void setChart3(Chart3 chart3) {
        this.chart3 = chart3;
    }
}
