package demo.view.home;

import org.december.beanui.chart.annotation.*;

@YAxis
@Tooltip(trigger = Tooltip.Trigger.AXIS)
public class Chart4 {
    @Color
    private String[] colors = {"#003366", "#006699", "#4cabce", "#e5323e"};

    @XAxis
    private String[] xAxisData = {"2012", "2013", "2014", "2015", "2016"};

    @Legend
    private String[] legendData = {"Forest", "Steppe", "Desert", "Wetland"};

    @BarChart.Series(name = "Forest")
    private int[] data1;

    @BarChart.Series(name = "Steppe")
    private int[] data2;

    @BarChart.Series(name = "Desert")
    private int[] data3;

    @BarChart.Series(name = "Wetland")
    private int[] data4;

    public int[] getData1() {
        return data1;
    }

    public void setData1(int[] data1) {
        this.data1 = data1;
    }

    public int[] getData2() {
        return data2;
    }

    public void setData2(int[] data2) {
        this.data2 = data2;
    }

    public int[] getData3() {
        return data3;
    }

    public void setData3(int[] data3) {
        this.data3 = data3;
    }

    public int[] getData4() {
        return data4;
    }

    public void setData4(int[] data4) {
        this.data4 = data4;
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

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }
}
