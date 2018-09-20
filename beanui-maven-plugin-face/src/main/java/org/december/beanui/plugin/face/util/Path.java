package org.december.beanui.plugin.face.util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path {
    public static String e(String exp) {
        Pattern p = Pattern.compile("\\$\\{[a-zA-Z0-9]+\\}");
        Matcher m = p.matcher(exp);
        while (m.find()) {
            String result = m.group();
            String property = PluginSystem.getProperty(result.substring(2, result.length()-1));
            exp = exp.replace(result, property);
        }
        return exp.replaceAll("\\/|\\\\", Matcher.quoteReplacement(File.separator));
    }

    public static void main(String[] args) {
        System.out.println(e("${workPath/index.html"));
    }
}
