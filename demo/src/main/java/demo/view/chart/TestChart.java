package demo.view.chart;

import org.december.beanui.chart.annotation.LineChart;
import org.december.beanui.chart.annotation.XAxis;
import org.december.beanui.chart.annotation.YAxis;

public class TestChart {
    @XAxis
    private String[] x;
    @YAxis
    private int[] y;

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

    public String[] getX() {
        return x;
    }

    public void setX(String[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }
}
