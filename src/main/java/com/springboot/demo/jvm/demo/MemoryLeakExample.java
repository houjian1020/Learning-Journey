package com.springboot.demo.jvm.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存泄漏实例：长生命周 期的对象持有短生命周期对象的引用就很可能发生内存泄露
 */
public class MemoryLeakExample {

    // 一个静态集合，它将在整个应用程序生命周期内存在
    private static List<Object> leakList = new ArrayList<>();

    public static void main(String[] args) {
        // 模拟一个不断添加对象到集合中的场景
        for (int i = 0; i < 100000; i++) {
            // 创建一个短生命周期的对象
            Object obj = new Object();

            // 将这个对象添加到静态集合中
            // 由于 leakList 是静态的，它将持有对 obj 的引用，导致 obj 无法被回收
            leakList.add(obj);

            // 在这里，obj 实际上已经不再需要了，但由于 leakList 持有它的引用，它不会被垃圾收集
        }

        // 此时，leakList 包含了大量不再需要的对象，导致内存泄漏
        // 如果这个过程持续进行，最终可能会导致内存耗尽
    }
}

