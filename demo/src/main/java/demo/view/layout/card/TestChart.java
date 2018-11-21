package demo.view.layout.card;

import org.december.beanui.chart.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Title(text = "abc")
@Toolbox(feature = "$feature")
public class TestChart {
    @XAxis
    private String[] x;
    @YAxis
    private int[] y;
    @LineChart.Series(areaStyle = "{}")
    private int[] line1;
    @LineChart.Series(areaStyle = "{}")
    private int[] line2;

    private Map feature = new HashMap() {{
        put("magicType", new HashMap() {{
            put("type", new ArrayList() {{
                add("line");
                add("bar");
            }});
        }});
    }};

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

    public Map getFeature() {
        return feature;
    }

    public void setFeature(Map feature) {
        this.feature = feature;
    }
}
