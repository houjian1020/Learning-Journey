package com.springboot.jianzhi.offer;

/**
 * 标题：替换空格
 *
 * 考点：掌握字符串常用方法 、  StringBuilder  char[]
 *
 * 思路：
 */
public class Offer003 {
    /**
     * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    public static void main(String[] args) {

        String str = "Welcome to the world of Java";

        // 使用String类的方法replaceAll
        String str1 = method1(str);
        System.out.println("替换空格后："+str1);

        // 遍历字符串 并 使用 StringBuilder拼接
        String str2 = method2(str);
        System.out.println("替换空格后："+str2);

        // 使用转换为char数组，遍历数组并替换
        String str3 = method2(str);
        System.out.println("替换空格后："+str3);
    }

    /**
     * 使用String类的方法replaceAll
     */
    static String method1(String str){
        return str.replaceAll(" ", "%20");
    }


    /**
     * 遍历字符串 并 使用 StringBuilder拼接
     */
    static String method2(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                stringBuilder.append("%20");
            }
            else{
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 使用转换为char数组，遍历数组并替换
     */
    static String method3(String str){
        // 将str存到字符数组中，数组长度为str的3倍（全部为空格的情况）
        char [] charArr = new char[str.length() * 3];
        // 初始化数组下标
        int index = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                charArr[index] = '%';
                index++;
                charArr[index] = '2';
                index++;
                charArr[index] = '0';
                index++;
            }
            else{
                charArr[index] = str.charAt(i);
                index++;
            }
        }
        return String.valueOf(charArr);
    }

}
