package org.december.beanui.plugin.face.util;

public class Platform {
    public static boolean isWin() {
        String os = System.getProperty("os.name");
        boolean isWin = false;
        if(os.toLowerCase().startsWith("win")){
            isWin = true;
        }
        return isWin;
    }
}
