package com.springboot.demo.thread.demo;

/**
 * synchronized可重入的
 */
public class ReentrantSyncExample {
    // 一个简单的共享资源
    private int count = 0;

    // 一个synchronized方法
    public synchronized void increment() {
        // 调用另一个synchronized方法
        doWork();
        count++;
    }

    // 另一个synchronized方法
    public synchronized void doWork() {
        // 模拟一些工作
        System.out.println("Doing work...");
    }

    public static void main(String[] args) {
        ReentrantSyncExample example = new ReentrantSyncExample();

        // 创建一个线程来执行increment方法
        Thread thread = new Thread(() -> {
            example.increment();
            example.increment();
        });

        // 启动线程
        thread.start();

        // 等待线程完成
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 输出最终的count值
        System.out.println("Final count: " + example.count);
    }
}
