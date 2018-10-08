package org.december.beanui.plugin.face.util;

import sun.net.www.protocol.file.FileURLConnection;

import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class FileUtil {
    public static void copyDir(String sourcePath, String newPath) {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                copyDir(sourcePath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
            }

            if (new File(sourcePath  + file.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }

    public static void copyFile(String oldPath, String newPath) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            File oldFile = new File(oldPath);
            File file = new File(newPath);
            in = new FileInputStream(oldFile);
            out = new FileOutputStream(file);
            byte[] buffer=new byte[2097152];
            int readByte = 0;
            while((readByte = in.read(buffer)) != -1){
                out.write(buffer, 0, readByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteDir(String path){
        path = Path.e(path);
        File file = new File(path);
        if(!file.exists()){//判断是否待删除目录是否存在
            System.err.println("The dir are not exists!");
            return false;
        }

        if(file.isFile()) {
            file.delete();
        } else {
            String[] content = file.list();//取得当前目录下所有文件和文件夹
            for(String name : content){
                File temp = new File(path, name);
                if(temp.isDirectory()){//判断是否是目录
                    deleteDir(temp.getAbsolutePath());//递归调用，删除目录里的内容
                    temp.delete();//删除空目录
                }else{
                    if(!temp.delete()){//直接删除文件
                        System.err.println("Failed to delete " + name);
                    }
                }
            }
        }
        return true;
    }

    public static void loadRecourseFromJarByFolder(String folderPath,String targetFolderPath ,Class clazz) throws IOException {
        loadRecourseFromJarByFolder(folderPath, targetFolderPath, clazz,null);
    }

    public static void loadRecourseFromJarByFolder(String folderPath,String targetFolderPath ,Class clazz, String[] filters) throws IOException {
        if(filters != null) {
            for(String filter:filters) {
                if(filter.equals(folderPath)) {
                    return;
                }
            }
        }

        URL url = clazz.getResource(folderPath);
        URLConnection urlConnection = url.openConnection();
        if (urlConnection instanceof FileURLConnection) {
            copyFileResources(url, folderPath,targetFolderPath,clazz, filters);
        } else if (urlConnection instanceof JarURLConnection) {
            copyJarResources((JarURLConnection) urlConnection,folderPath,targetFolderPath,clazz);
        }
    }

    /**
     * 当前运行环境资源文件是在文件里面的
     *
     * @param url
     * @param folderPath
     * @param clazz
     * @throws IOException
     */
    private static void copyFileResources(URL url, String folderPath,String targetFolderPath, Class clazz,  String[] filters) throws IOException {
        File root = new File(url.getPath());
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    loadRecourseFromJarByFolder(folderPath + "/" + file.getName(),targetFolderPath,clazz,  filters);
                } else {
                    loadRecourseFromJar(folderPath + "/" + file.getName(),folderPath,clazz);
                }
            }
        }
    }

    /**
     * 当前运行环境资源文件是在jar里面的
     *
     * @param jarURLConnection
     * @throws IOException
     */
    private static void copyJarResources(JarURLConnection jarURLConnection, String folderPath, String targetFolderPath, Class clazz) throws IOException {
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> entrys = jarFile.entries();
        while (entrys.hasMoreElements()) {
            JarEntry entry = entrys.nextElement();
            if (entry.getName().startsWith(jarURLConnection.getEntryName()) && !entry.getName().endsWith("/")) {
                loadRecourseFromJar("/" + entry.getName(),targetFolderPath,clazz);
            }
        }
        jarFile.close();
    }

    public static void loadRecourseFromJar(String path,String recourseFolder,Class clazz) throws IOException {
        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("The path has to be absolute (start with '/').");
        }

        if (path.endsWith("/")) {
            throw new IllegalArgumentException("The path has to be absolute (cat not end with '/').");
        }

        int index = path.lastIndexOf('/');

        String filename = path.substring(index + 1);
        String folderPath = recourseFolder + path.substring(0, index + 1);

        // If the folder does not exist yet, it will be created. If the folder
        // exists already, it will be ignored
        File dir = new File(folderPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // If the file does not exist yet, it will be created. If the file
        // exists already, it will be ignored
        filename = folderPath + filename;
        File file = new File(filename);

        if (!file.exists() && !file.createNewFile()) {
            return;
        }

        // Prepare buffer for data copying
        byte[] buffer = new byte[1024];
        int readBytes;

        // Open and check input stream
        URL url = clazz.getResource(path);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();

        if (is == null) {
            throw new FileNotFoundException("File " + path + " was not found inside JAR.");
        }
        OutputStream os = new FileOutputStream(file);
        try {
            while ((readBytes = is.read(buffer)) != -1) {
                os.write(buffer, 0, readBytes);
            }
        } finally {
            os.close();
            is.close();
        }
    }
}
