package demo.view.home;

import org.december.beanui.chart.KV;
import org.december.beanui.chart.annotation.Legend;
import org.december.beanui.chart.annotation.RadarChart;
import org.december.beanui.chart.annotation.Tooltip;

@Tooltip(trigger = Tooltip.Trigger.ITEM)
public class Chart2 {
    @Legend
    private String[] legendData = {"预算分配", "实际开销"};

    @RadarChart.Series
    private KV[] data1;

    public KV[] getData1() {
        return data1;
    }

    public void setData1(KV[] data1) {
        this.data1 = data1;
    }

    public String[] getLegendData() {
        return legendData;
    }

    public void setLegendData(String[] legendData) {
        this.legendData = legendData;
    }
}
