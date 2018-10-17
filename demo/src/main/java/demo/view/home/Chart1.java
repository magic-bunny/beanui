package demo.view.home;

import org.december.beanui.chart.annotation.*;

@YAxis
@Grid(left = "1%", right = "1%", bottom = "1%", containLabel = "true")
@Tooltip(trigger = Tooltip.Trigger.AXIS)
public class Chart1 {
    @Legend
    private String[] legendData = {"expected", "actual"};
    @LineChart.Series(name = "expected")
    private int[] line1;
    @LineChart.Series(name = "actual")
    private int[] line2;
    @XAxis(boundaryGap = "false")
    private String[] xAxisData = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

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

    public String[] getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(String[] xAxisData) {
        this.xAxisData = xAxisData;
    }

    public String[] getLegendData() {
        return legendData;
    }

    public void setLegendData(String[] legendData) {
        this.legendData = legendData;
    }
}
