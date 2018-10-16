package org.december.beanui.chart.annotation;

import org.december.beanui.chart.Config;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface PieChart {
    @Documented
    @Target(ElementType.FIELD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Series {
        String tag() default "series";
        String type() default "pie";
        String id() default "";
        String name() default "";
        String legendHoverLink() default "";
        String hoverAnimation() default "";
        String hoverOffset() default "";
        String selectedMode() default "";
        String selectedOffset() default "";
        String clockwise() default "";
        String startAngle() default "";
        String minAngle() default "";
        String roseType() default "";
        String avoidLabelOverlap() default "";
        String stillShowZeroSum() default "";
        String cursor() default "";
        String label() default "";
        String labelLine() default "";
        String itemStyle() default "";
        String emphasis() default "";
        String zlevel() default "";
        String z() default "";
        String center() default "";
        String radius() default "";
        String seriesLayoutBy() default "";
        String datasetIndex() default "";
        String data() default Config.DEFAULT_PROPERTY;
        String markPoint() default "";
        String markLine() default "";
        String markArea() default "";
        String silent() default "";
        String animationType() default "";
        String animation() default "";
        String animationThreshold() default "";
        String animationDuration() default "";
        String animationEasing() default "";
        String animationDelay() default "";
        String animationDurationUpdate() default "";
        String animationEasingUpdate() default "";
        String animationDelayUpdate() default "";
        String tooltip() default "";

        class RoseType {
            public static final String RADIUS = "radius";
            public static final String AREA = "area";
            public static final String FALSE = "false";

        }
    }
}
