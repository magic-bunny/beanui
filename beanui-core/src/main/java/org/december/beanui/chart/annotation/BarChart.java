package org.december.beanui.chart.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface BarChart {
    @Documented
    @Target(ElementType.FIELD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Series {
        String type() default "";
        String id() default "";
        String name() default "";
        String legendHoverLink() default "";
        String coordinateSystem() default "";
        String xAxisIndex() default "";
        String yAxisIndex() default "";
        String label() default "";
        String itemStyle() default "";
        String emphasis() default "";
        String stack() default "";
        String cursor() default "";
        String barWidth() default "";
        String barMaxWidth() default "";
        String barMinHeight() default "";
        String barGap() default "";
        String barCategoryGap() default "";
        String large() default "";
        String largeThreshold() default "";
        String progressive() default "";
        String progressiveThreshold() default "";
        String progressiveChunkMode() default "";
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
