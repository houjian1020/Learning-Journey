package com.springboot.demo.thread.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        int poolSize = 3;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        //计数器初始值设为任务的总数，假设我们有5个任务要执行
        int numberOfTasks = 5;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        // 定义一个Runnable任务，任务执行完毕后调用countDown()
        Runnable task = () -> {
            try {
                // 模拟任务执行时间
                Thread.sleep((int) (Math.random() * 2000));
                System.out.println(Thread.currentThread().getName() + " 任务完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 任务完成后，将CountDownLatch的计数器减一
                latch.countDown();
            }
        };

        // 向线程池提交任务
        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(task);
        }

        // 任务A，需要等待其他所有任务完成后才能执行
        Runnable taskA = () -> {
            try {
                // 等待CountDownLatch的计数器归零
                latch.await();
                // 当计数器归零时，执行任务A
                System.out.println(Thread.currentThread().getName() + " 任务A开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 使用单独的线程执行任务A，以确保它不会阻塞线程池中的线程
        new Thread(taskA, "任务A-线程").start();

        // 关闭线程池（这通常在实际应用中是必要的，以避免资源泄漏）
        // 注意：这里我们不应该立即关闭线程池，因为任务A可能还没有开始执行
        // 因此，我们应该在任务A执行完毕后再关闭线程池
        // 可以使用executor.shutdown()和executor.awaitTermination()来实现这一点

        // 为了演示目的，这里我们使用一个简单的延时来确保任务A有足够的时间执行
        // 在实际应用中，应该使用更健壮的同步机制（例如，使用另一个CountDownLatch或CyclicBarrier）
        try {
            // 延时等待任务A执行完毕（这只是一个粗略的估计，实际应用中需要更精确的控制）
            Thread.sleep(3000); // 假设任务A和其他任务总共不会超过3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 正确的做法是在任务A执行完毕后调用shutdown()，这里为了简化代码而使用了延时
        executor.shutdown(); // 关闭线程池（不再接收新任务，但会继续执行已提交的任务）

        // 如果需要的话，可以等待线程池中的任务全部执行完毕后再继续（例如，在程序结束之前）
        // executor.awaitTermination(long timeout, TimeUnit unit) 可以用于此目的
    }
}
