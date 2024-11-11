package com.springboot.demo.thread.demo;

/**
 * wait 和  notify 方法使用
 */
public class WaitAndNotifyExample {
        public static void main(String[] args) {
            final Object lock = new Object();

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println("线程1正在运行...");
                        try {
                            // 线程1等待,并释放锁
                            System.out.println("线程1进入wait...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程1被唤醒，继续运行...");
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println("线程2正在运行...");
                        // 唤醒正在lock对象上等待的单个线程
                        lock.notify();
                        System.out.println("线程2唤醒线程1后继续运行...");
                    }
                }
            });

            thread1.start();
            try {
                // 确保线程1先运行
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread2.start();
        }

}
