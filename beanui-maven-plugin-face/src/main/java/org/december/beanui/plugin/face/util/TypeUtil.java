package org.december.beanui.plugin.face.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeUtil {
    public static boolean isJSON(String text) {
        if((text.startsWith("[") && text.endsWith("]")) || (text.startsWith("{") && text.endsWith("}"))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumber(String text) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(text);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public static boolean isTrue(String text) {
        if("true".equals(text)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFalse(String text) {
        if("false".equals(text)) {
            return true;
        } else {
            return false;
        }
    }
}
