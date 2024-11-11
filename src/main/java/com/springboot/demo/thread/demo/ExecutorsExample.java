package com.springboot.demo.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) {

    }

    /**
     * 特点：创建一个固定线程数的线程池
     * 缺点：线程数量是固定的，但是阻塞队列是无界队列。如果有很多请求积压，阻塞队列越来越长，
     * 容易导致OOM（超出内存空间）
     */
    private static void newFixedThreadPoolMethod(){
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newFixedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ",i==" + temp);
                }
            });
        }
        newFixedThreadPool.shutdown();

    }


    /**
     * 特点：创建一个可缓存的线程池，线程数不固定，根据需求动态增长或缩减。
     * 缺点：虽然可以无线的新建线程，但是容易造成堆外内存溢出
     */
    private static void newCachedThreadPoolMethod(){
        // 创建无限大小线程池，由jvm自动回收
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {}
                    System.out.println(Thread.currentThread().getName() +",i==" + temp);
                }
            });
        }
        newCachedThreadPool.shutdown();
    }


    /**
     * 特点：创建一个单线程的线程池，保证任务按顺序执行
     * 缺点：不适用于高并发业务
     */
    private static void newSingleThreadExecutorMethod(){
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "index:" + index);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {}
                }
            });
        }
        newSingleThreadExecutor.shutdown();


    }


    /**
     * 特点：创建一个定时或周期性的任务执行线程池
     * 缺点：由于所有任务都是由同一个线程来调度，因此所有任务都是串行执行的
     */
    private static void newScheduledThreadPoolMethod(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.schedule(() -> {
            System.out.println("Task executed at fixed delay");
        }, 5, TimeUnit.SECONDS); //延迟5秒执行一次任务。

        executor.scheduleAtFixedRate(() -> {
            System.out.println("Task executed at fixed rate");
        }, 2, 5, TimeUnit.SECONDS); // 首次执行前有2秒的延迟  每5秒执行一次任务

        // 注意：需要适时调用shutdown()来关闭线程池，避免资源泄露

    }


    /**
     * 创建一个单线程的定时或周期性的任务执行器
     */
    private static void newSingleThreadScheduledExecutorMethod(){
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            System.out.println("Single thread task executed at fixed delay");
        }, 5, TimeUnit.SECONDS);

        executor.shutdown();


    }



}
