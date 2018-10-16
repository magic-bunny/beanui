package demo.view.home;

import org.december.beanui.chart.KV;
import org.december.beanui.chart.annotation.PieChart;

public class Chart3 {
    @PieChart.Series(roseType = PieChart.Series.RoseType.RADIUS)
    private KV[] data1;

    public KV[] getData1() {
        return data1;
    }

    public void setData1(KV[] data1) {
        this.data1 = data1;
    }
}
