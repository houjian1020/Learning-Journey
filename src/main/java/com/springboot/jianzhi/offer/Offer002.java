package com.springboot.jianzhi.offer;

/**
 * 标题：二维数组中查找
 *
 * 考点：数组转二叉树
 *
 * 思路：将该二维数组看做二叉树,可以把左下角  或 右上角 作为父节点。 一下是以右上角为父节点
 */
public class Offer002 {
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */

    public static void main(String[] args) {

        int arr[][] = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        // 数组转二叉树
        boolean isExist1 = method1(8,arr);
        System.out.println("二维数组中查找："+isExist1);

        // 蛮力法
        boolean isExist2 = method2(10,arr);
        System.out.println("二维数组中查找："+isExist2);

    }

    /**
     * 将该二维数组看做二叉树,可以把左下角  或 右上角 作为父节点。 一下是以右上角为父节点
     * @param num
     * @param arr
     * @return
     */
    static boolean method1(int num, int arr[][]){
        // 非空判断
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return false;
        }

        // 行数
        int rows = arr.length;
        // 列数
        int colums = arr[0].length;
        // 第一行下标
        int row = 0;
        // 最后一列下标
        int colum = colums-1;
        // 循环条件：行<rows 且 列 >= 0
        while (row < rows && colum >= 0){
            if(num == arr[row][colum]){
                return true;
            }
            else if(num > arr[row][colum]){   // 目标数  大于 当前节点 向下比较（换行）
                row++;
            }
            else{    // 目标数  小于 当前节点 向左比较（换列）
                colum--;
            }
        }

        return false;
    }


    /**
     * 蛮力法：循环遍历所有数值，效率低（不推荐）
     * @param num
     * @param arr
     * @return
     */
    static boolean method2(int num, int arr[][]){

        // 非空判断
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return false;
        }
        for(int i = 0; i < arr.length; i++){   // 从左到右（从左到右依次递增），从上到下遍历（从上到下依次递增）
            for(int j = 0; j < arr[i].length; j++){
                if(num < arr[i][j]){   // 退出本行循环，进入下一行
                    break;
                }
                if(num == arr[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
