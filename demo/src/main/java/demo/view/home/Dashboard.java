package demo.view.home;

import org.december.beanui.element.annotation.Card;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Subplot;

@Component
public class Dashboard {
    @Subplot({4, 1, 1})
    @Card
    private CardForm cardForm;

    @Subplot({4, 1, 2})
    @Card
    private ChartForm1 chartForm1;

    @Subplot({4, 3, 3})
    @Card
    private ChartForm2 chartForm2;

    @Subplot({4, 3, 4})
    @Card
    private ChartForm3 chartForm3;

    @Subplot({4, 3, 5})
    @Card
    private ChartForm4 chartForm4;

    @Subplot({4, 2, 7})
    @Card
    private TableForm tableForm;

    @Subplot({4, 2, 8})
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

    public CardForm getCardForm() {
        return cardForm;
    }

    public void setCardForm(CardForm cardForm) {
        this.cardForm = cardForm;
    }

    public Top5Form getTop5Form() {
        return top5Form;
    }

    public void setTop5Form(Top5Form top5Form) {
        this.top5Form = top5Form;
    }
}
