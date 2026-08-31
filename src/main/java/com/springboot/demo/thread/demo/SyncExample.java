package com.springboot.demo.thread.demo;


import java.util.concurrent.locks.ReentrantLock;

/**
 * sychronized  volatile  reentrantlock 的使用案例
 */
public class SyncExample {
    public static void main(String[] args) {

    }

    //    synchronized关键字修饰的方法: 锁住这个对象
    public synchronized void syncMethod() {
        System.out.println("Synchronized method is running");
    }

    //    synchronized关键字修饰的代码块
    private final Object lockObj = new Object();
    public void method() {
        synchronized(lockObj) {
            System.out.println("Synchronized block is running");
        }
    }
    //    reentrantlock类是可重入锁
    private final ReentrantLock lock = new ReentrantLock();
    public void lockMethod() {
        lock.lock();
        try {
            System.out.println("ReentrantLock is locking");
        } finally {
            lock.unlock();
        }
    }

    //    volatile关键字用于确保变量的可见性和顺序性，但不保证原子性
    private volatile boolean flag = false;
    public void writeFlag() {
        this.flag = true;
    }

    public void readFlag() {
        if (flag) {
            System.out.println("Flag is true");
        }
    }



}
