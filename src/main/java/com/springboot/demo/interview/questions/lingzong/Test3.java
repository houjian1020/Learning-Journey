package com.springboot.demo.interview.questions.lingzong;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

/**
 * 考点：文件操作+递归
 * 文件路径输出来，包括所有子目录的文件
 */
public class Test3 {
    public static void main(String[] args) {
        File dir = new File("D:"+File.separator+"HJ"+File.separator+"test3");
        if(dir.exists() && dir.isDirectory()){
            printFilePath(dir);
        }
    }

    private static void printFilePath(File dir) {
        for(File file : Objects.requireNonNull(dir.listFiles())){
            if(file.isFile()){
                System.out.println(file.getAbsolutePath());
            }
            else if(file.isDirectory()){
                // 递归
                printFilePath(file);
            }

        }
    }
}
