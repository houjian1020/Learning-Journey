package com.springboot.demo.thread.demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        // 创建线程池的核心参数
        // 1、核心线程数
        int corePoolSize = 5;
        // 2、最大线程数
        int maximumPoolSize = 10;
        // 4、非核心线程的空闲存活时间
        long keepAliveTime = 60;
        // 5、keepAliveTime的时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(50); // 任务队列

        ///6、线程池工厂：新线程的产生方式
        ThreadFactory customThreadFactory = new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "CustomThreadPool-Thread-" + threadNumber.getAndIncrement());
                // 可以根据需要设置线程的优先级、是否为守护线程等属性
                return thread;
            }
        };

        ///7、拒绝策略：直接抛出异常（默认）、回退、丢弃、丢弃最旧的
        RejectedExecutionHandler customHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.err.println("Task " + r.toString() + " rejected from " + executor.toString());
            }
        };

        // 创建 ThreadPoolExecutor 对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                customThreadFactory,
                customHandler
        );

        // 提交任务到线程池
        for (int i = 0; i < 100; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is running Task " + taskNumber);
                try {
                    Thread.sleep(2000); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 关闭线程池（这里等待所有任务完成后再关闭，也可以根据实际情况选择其他关闭方式）
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow(); // 如果超时则强制关闭
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // 如果被打断则强制关闭
        }
    }
}
