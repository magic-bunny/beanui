package demo.view.chart;

import org.december.beanui.chart.annotation.LineChart;

public class TestChart {
    @LineChart.Series
    private int[] line1;
    @LineChart.Series
    private int[] line2;

    public int[] getLine1() {
        return line1;
    }

    public void setLine1(int[] line1) {
        this.line1 = line1;
    }

    public int[] getLine2() {
        return line2;
    }

    public void setLine2(int[] line2) {
        this.line2 = line2;
    }
}
