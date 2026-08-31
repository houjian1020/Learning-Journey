package com.springboot.demo.thread.demo;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        int poolSize = 3;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        // 初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("所有线程已到达屏障点，共同任务执行完毕！");
        });

        // 定义一个Runnable任务
        Runnable task = () -> {
            try {
                // 模拟任务执行时间
                Thread.sleep((int) (Math.random() * 2000));
                System.out.println(Thread.currentThread().getName() + " 任务完成，等待其他线程...");

                // 等待其他线程到达屏障点
                barrier.await();

                // 当所有线程都到达屏障点后，执行下面的代码
                System.out.println(Thread.currentThread().getName() + " 继续执行后续操作");
            }
            catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        // 向线程池提交任务
        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(task);
        }

        // 关闭线程池（这通常在实际应用中是必要的，以避免资源泄漏）
        // 应该在所有任务执行完毕后再关闭线程池
        executor.shutdown();

        // 等待线程池中的任务全部执行完毕（包括由CyclicBarrier触发的回调任务）
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
