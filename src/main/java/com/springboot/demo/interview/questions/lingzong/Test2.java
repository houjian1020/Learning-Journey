package com.springboot.demo.interview.questions.lingzong;

import java.io.*;
import java.nio.file.Files;

/**
 * 考点：读取字符流+字符串转字符+字符转数字
 * 文本文件求和：对文件中每一行的数字求和
 */
public class Test2 {

    public static void main(String[] args) {
        // 获取文件
        File file = new File("C:"+File.separator+"Users"+File.separator+"15067"+File.separator+"Desktop"+File.separator+"test2.txt");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            // 求和值
            int sum = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                for (int i = 0; i < line.length(); i++){
                    char valueChar = line.charAt(i);
                    // 判断是否数字
                    if (Character.isDigit(valueChar)){
                        // 转int
                        int numericValue = Character.getNumericValue(valueChar);
                        sum += numericValue;
                    }
                }
            }
//            while ((line = bufferedReader.readLine()) != null) {
//                char[] charArray = line.toCharArray();
//                for (int i = 0; i < charArray.length; i++) {
//                    char valueChar = line.charAt(i);
//                    // 判断是否数字
//                    if (Character.isDigit(valueChar)){
//                        // 转int
//                        int numericValue = Character.getNumericValue(valueChar);
//                        sum += numericValue;
//                    }
//                }
//                System.out.println(line);
//            }
            // 总和
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
