package com.springboot.demo.collection.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 迭代器使用
 */
public class IteratorExample {
    public static void main(String[] args) {

    }

    private static void iterator(){
        // 创建一个ArrayList并添加一些字符串元素
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Grape");
        list.add("Orange");

        // 获取ArrayList的迭代器
        Iterator<String> iterator = list.iterator();

//        最常见的错误代码如下
//        for(String i : list){
//            list.remove(i);
//        }

        // 使用迭代器遍历ArrayList，并删除长度为5的字符串元素
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.length() == 5) {
                iterator.remove(); // 删除长度为5的字符串元素
            }
        }

        // 打印修改后的ArrayList
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }


    /**
     * 反向迭代器
     */
    private static void listIterator(){
        // 创建一个ArrayList并添加一些字符串元素
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Grape");
        list.add("Orange");

        // 获取ArrayList的反向列表迭代器
        ListIterator<String> listIterator = list.listIterator(list.size());

        // 使用反向迭代器遍历ArrayList，并删除长度为5的字符串元素
        while (listIterator.hasPrevious()) {
            String fruit = listIterator.previous();
            if (fruit.length() == 5) {
                listIterator.remove(); // 删除长度为5的字符串元素
            }
        }

        // 打印修改后的ArrayList
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }

}
