package org.december.beanui.plugin.face.util;

import java.io.*;
import java.util.Arrays;

public class ConsoleUtil {
    public static void exec(String shell, String workPath) {
        shell = Platform.isWin()?("cmd /c " + shell):shell;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(Arrays.asList(shell.split(" ")));
        processBuilder.directory(new File(workPath));
        processBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}