package demo.view.home;

import org.december.beanui.element.annotation.Card;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Subplot;

@Component
public class Dashboard {
    @Subplot({2, 1, 1})
    @Card
    private ChartForm1 chartForm1;

    @Subplot({2, 2, 2})
    @Card
    private ChartForm2 chartForm2;

    @Subplot({2, 2, 3})
    @Card
    private ChartForm3 chartForm3;

    public ChartForm1 getChartForm1() {
        return chartForm1;
    }

    public void setChartForm1(ChartForm1 chartForm1) {
        this.chartForm1 = chartForm1;
    }

    public ChartForm2 getChartForm2() {
        return chartForm2;
    }

    public void setChartForm2(ChartForm2 chartForm2) {
        this.chartForm2 = chartForm2;
    }

    public ChartForm3 getChartForm3() {
        return chartForm3;
    }

    public void setChartForm3(ChartForm3 chartForm3) {
        this.chartForm3 = chartForm3;
    }
}
