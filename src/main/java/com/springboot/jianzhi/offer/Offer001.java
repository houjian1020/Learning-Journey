package com.springboot.jianzhi.offer;

import java.util.HashSet;

/**
 * 标题：数组中重复的数字
 *
 * 考点：Set集合不可重复
 *
 * 思路：判断一个数字是否重复遇到，使用Set集合存储已经遇到的数字，如果遇到的一个数字已经在集合中，则当前的数字是重复数字。
 */
public class Offer001 {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，
     * 那么对应的输出是2或者3。存在不合法的输入的话输出-1
     *
     * 数据范围：0-10000
     */


    public static void main(String[] args) {

        int arr[] = {1,2,4,5,3,7,4};
        // 使用Set集合不允许重复的特点
        int repeatNumber1 = method1(arr);
        System.out.println("任意一个重复数字："+repeatNumber1);

        // 蛮力法
        int repeatNumber2 = method2(arr);
        System.out.println("任意一个重复数字："+repeatNumber2);
    }

    /**
     * Set集合的使用
     * @param arr
     * @return
     */
    private static int method1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++){
                boolean add = set.add(arr[i]);   // ture 成功  false 失败
                if(!add){
                    return arr[i];
                }
            }
        }
        return -1;
    }


    /**
     * 蛮力法：循环所有，效率低  （不推荐）
     * @param arr
     * @return
     */
    static int method2(int arr[]){
        if(arr.length > 0){
            int num = -1;
            for (int i = 0; i < arr.length -1; i++) {
                    int now = arr[i];   // 当前值
                for (int j = i+1; j < arr.length; j++) {
                    int next = arr[j];   // 下一个值
                    if(now == next){    // 当前和下一个是否相等：相等就返回该数值并退出循环，否则继续取下一个值进行比较
                        num = now;
                        break;
                    }
                }
                if(num != -1){
                    break;
                }
            }
            return num;
        }

        return -1;
    }


}
