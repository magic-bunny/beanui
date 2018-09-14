package org.december.beanui.i18n.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface I18N {
    //简体中文
	String zh_CN() default "";
    //英语
	String en() default "";
    //德语
	String de() default "";
    //葡萄牙语
	String pt() default "";
    //西班牙语
	String es() default "";
    //丹麦语
	String da() default "";
    //法语
	String fr() default "";
    //挪威语
	String nb_NO() default "";
    //繁体中文
	String zh_TW() default "";
    //意大利语
	String it() default "";
    //韩语
	String ko() default "";
    //日语
	String ja() default "";
    //荷兰语
	String nl() default "";
    //越南语
	String vi() default "";
    //俄语
	String ru_RU() default "";
    //土耳其语
	String tr_TR() default "";
    //巴西葡萄牙语
	String pt_br() default "";
    //波斯语
	String fa() default "";
    //泰语
	String th() default "";
    //印尼语
	String id() default "";
    //保加利亚语
	String bg() default "";
    //波兰语
	String pl() default "";
    //芬兰语
	String fi() default "";
    //瑞典语
	String sv_SE() default "";
    //希腊语
	String el() default "";
    //斯洛伐克语
	String sk() default "";
    //加泰罗尼亚语
	String ca() default "";
    //捷克语
	String cs_CZ() default "";
    //乌克兰语
	String ua() default "";
    //土库曼语
	String tk() default "";
    //泰米尔语
	String ta() default "";
    //拉脱维亚语
	String lv() default "";
    //南非荷兰语
	String af_ZA() default "";
    //爱沙尼亚语
	String ee() default "";
    //斯洛文尼亚语
	String sl() default "";
    //阿拉伯语
	String ar() default "";
    //希伯来语
	String he() default "";
    //立陶宛语
	String lt() default "";
    //蒙古语
	String mn() default "";
    //哈萨克斯坦语
	String kz() default "";
    //匈牙利语
	String hu() default "";
    //罗马尼亚语
	String ro() default "";
    //库尔德语
	String ku() default "";
    //维吾尔语
	String ug_CN() default "";
    //高棉语
	String km() default "";
}
