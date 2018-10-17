package demo.view.home;

import org.december.beanui.element.annotation.Card;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Subplot;

@Component
public class Dashboard {
    @Subplot({3, 1, 1})
    @Card
    private ChartForm1 chartForm1;

    @Subplot({3, 3, 2})
    @Card
    private ChartForm2 chartForm2;

    @Subplot({3, 3, 3})
    @Card
    private ChartForm3 chartForm3;

    @Subplot({3, 3, 4})
    @Card
    private ChartForm4 chartForm4;

    @Subplot({3, 2, 5})
    @Card
    private TableForm tableForm;

    @Subplot({3, 2, 6})
    @Card
    private Top5Form top5Form;

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

    public ChartForm4 getChartForm4() {
        return chartForm4;
    }

    public void setChartForm4(ChartForm4 chartForm4) {
        this.chartForm4 = chartForm4;
    }

    public TableForm getTableForm() {
        return tableForm;
    }

    public void setTableForm(TableForm tableForm) {
        this.tableForm = tableForm;
    }
}
