package org.december.beanui.chart.annotation;

import org.december.beanui.chart.Config;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RadarChart {
    String tag() default "radar";
    String id() default "";
    String zlevel() default "";
    String z() default "";
    String center() default "";
    String radius() default "";
    String startAngle() default "";
    String name() default "";
    String nameGap() default "";
    String splitNumber() default "";
    String shape() default "";
    String scale() default "";
    String silent() default "";
    String triggerEvent() default "";
    String axisLine() default "";
    String splitLine() default "";
    String splitArea() default "";
    String indicator() default Config.DEFAULT_PROPERTY;
    
    @Documented
    @Target(ElementType.FIELD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Series {
        String tag() default "series";
        String type() default "radar";
        String id() default "";
        String name() default "";
        String radarIndex() default "";
        String symbol() default "";
        String symbolSize() default "";
        String symbolRotate() default "";
        String symbolKeepAspect() default "";
        String symbolOffset() default "";
        String label() default "";
        String itemStyle() default "";
        String lineStyle() default "";
        String areaStyle() default "";
        String emphasis() default "";
        String data() default Config.DEFAULT_PROPERTY;
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
