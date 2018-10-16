package demo.view.home;

import org.december.beanui.chart.KV;
import org.december.beanui.chart.annotation.Legend;
import org.december.beanui.chart.annotation.RadarChart;

@Legend(data = "['预算分配（Allocated Budget）', '实际开销（Actual Spending）']")
public class Chart2 {
    @RadarChart.Series
    private KV[] data1;

    public KV[] getData1() {
        return data1;
    }

    public void setData1(KV[] data1) {
        this.data1 = data1;
    }
}
