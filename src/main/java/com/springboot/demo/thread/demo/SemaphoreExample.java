package com.springboot.demo.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        int poolSize = 5;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        // 初始化Semaphore，设置允许同时访问的线程数量为3
        int maxConcurrentThreads = 3;
        Semaphore semaphore = new Semaphore(maxConcurrentThreads);

        // 定义一个Runnable任务
        Runnable task = () -> {
            try {
                // 尝试获取Semaphore的许可
                semaphore.acquire();

                // 模拟任务执行时间
                System.out.println(Thread.currentThread().getName() + " 获取到许可，开始执行任务");
                Thread.sleep((int) (Math.random() * 2000));

                // 任务完成，释放Semaphore的许可:释放一个，才能开始下一个
                System.out.println(Thread.currentThread().getName() + " 任务完成，释放许可");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 向线程池提交任务
        int numberOfTasks = 10;
        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(task);
        }

        // 关闭线程池（这在实际应用中是必要的，以避免资源泄漏）
        // 应该在所有任务执行完毕后再关闭线程池
        executor.shutdown();

        // 等待线程池中的任务全部执行完毕
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // 如果在指定时间内没有终止，强制关闭线程池
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // 在等待过程中被中断，强制关闭线程池
            executor.shutdownNow();
        }
    }
}
