package org.december.beanui.chart.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface LineChart {
    @Documented
    @Target(ElementType.FIELD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Series {
        String type() default "";
        String id() default "";
        String name() default "";
        String coordinateSystem() default "";
        String xAxisIndex() default "";
        String yAxisIndex() default "";
        String polarIndex() default "";
        String symbol() default "";
        String symbolSize() default "";
        String symbolRotate() default "";
        String symbolKeepAspect() default "";
        String symbolOffset() default "";
        String showSymbol() default "";
        String showAllSymbol() default "";
        String hoverAnimation() default "";
        String legendHoverLink() default "";
        String stack() default "";
        String cursor() default "";
        String connectNulls() default "";
        String clipOverflow() default "";
        String step() default "";
        String label() default "";
        String itemStyle() default "";
        String lineStyle() default "";
        String areaStyle() default "";
        String emphasis() default "";
        String smooth() default "";
        String smoothMonotone() default "";
        String sampling() default "";
        String dimensions() default "";
        String encode() default "";
        String seriesLayoutBy() default "";
        String datasetIndex() default "";
        String data() default "";
        String markPoint() default "";
        String markLine() default "";
        String markArea() default "";
        String zlevel() default "";
        String z() default "";
        String silent() default "";
        String animation() default "";
        String animationThreshold() default "";
        String animationDuration() default "";
        String animationEasing() default "";
        String animationDelay() default "";
        String animationDurationUpdate() default "";
        String animationEasingUpdate() default "";
        String animationDelayUpdate() default "";
        String tooltip() default "";
    }
}
