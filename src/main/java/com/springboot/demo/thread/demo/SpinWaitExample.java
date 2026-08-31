package com.springboot.demo.thread.demo;

import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

public class SpinWaitExample {
    private volatile boolean flag = false;

    public void waitForFlag() {
        // 自旋等待flag变为true
        while (!flag) {
            // 在这里什么都不做，只是不断地检查flag的值
            // 这会导致CPU资源的浪费，因此在实际应用中应该谨慎使用
            System.out.println("在这里什么都不做，只是不断地检查flag的值......");
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws InterruptedException {
        SpinWaitExample example = new SpinWaitExample();

        Thread thread = new Thread(() -> {
            try {
                // 模拟一些工作，然后设置flag为true
                Thread.sleep(1000); // 假设这里有一些耗时的操作
                example.setFlag(true);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread.start();

        // 主线程将自旋等待，直到flag变为true
        long startTime = System.nanoTime();
        example.waitForFlag();
        long endTime = System.nanoTime();

        System.out.println("Waited " + (endTime - startTime) + " nanoseconds.");
    }
}
