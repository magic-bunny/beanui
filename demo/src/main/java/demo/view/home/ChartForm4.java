package demo.view.home;

import demo.controller.home.DashboardController;
import org.december.beanui.chart.annotation.BarChart;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.event.annotation.Created;

@Form
@Created(rest = DashboardController.class, func = "test4")
public class ChartForm4 {
    @BarChart
    private Chart4 chart4;

    public Chart4 getChart4() {
        return chart4;
    }

    public void setChart4(Chart4 chart4) {
        this.chart4 = chart4;
    }
}
