package com.springboot.demo.interview.questions.lingzong;

/**
 * 水花仙数实现：三位数，其各位数字立方和等于该数本身
 ** 考点：百位 十位 个位的截取+立方函数的使用
 */
public class Test1 {


    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            // 百位
            int a = i / 100;
            // 十位
            int b = (i / 10) % 10;
            // 个位
            int c = i % 10;
            // 求立方和
            int sum = (int) (Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3));
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
