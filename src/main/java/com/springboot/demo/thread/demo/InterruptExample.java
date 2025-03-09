package com.springboot.demo.thread.demo;

/**
 * 中断相关的几个方法的使用
 */
public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {
        //interrupt();  // 线程中没有使用sleep() 可正常中断
        sleepInterrupt();  // 线程中使用了sleep() 中断后会继续运行  需要捕获异常 并在catch中break
 }


    /**
     * 正常中断线程
     */
    private static void interrupt(){
        // 创建一个线程，该线程将执行一个无限循环，直到它被中断
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                i++;
                System.out.println(Thread.currentThread().getName()+ i +"子线程正在运行...");
            }
            System.out.println(Thread.currentThread().getName()+ i +"子线程被中断...");
        });

        thread.start();
       for (int i = 0; i < 10; i++) {
           System.out.println("主线程正在运行..." + i);
           if (i == 5){
               thread.interrupt();
       }

        }
    }


    /**
     *  中断线程中使用了 sleep()
     */
    private static void sleepInterrupt() throws InterruptedException {
        // 创建一个线程，该线程将执行一个无限循环，直到它被中断
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("子线程正在运行...");
                try {
                    // 使线程休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 当线程休眠时被中断，会抛出InterruptedException异常
                    System.out.println("线程被中断，但仍在运行...（因为catch块中没有break退出循环）");
                    // 注意：此时线程的中断标志已经被设置，但线程还在运行
                    // 如果想要线程在捕获到中断异常后立即退出，可以在这里添加break语句或返回语句
                    break;
                }
            }
            System.out.println("子线程已停止。");
        });

        // 启动线程
        thread.start();

        // 主线程休眠3秒，以便给上面的线程一些运行时间
        Thread.sleep(3000);

        // 中断上面的线程
        thread.interrupt();
        System.out.println("已请求中断子线程。");

        // 使用interrupted()方法检查当前线程（即主线程）是否被中断，并清除中断标志
        // 注意：这里检查的是主线程的中断状态，而不是我们创建的thread线程的中断状态
        System.out.println("主线程的中断状态（通过interrupted()方法）: " + Thread.interrupted()); // 输出false，因为主线程没有被中断

        // 使用isInterrupted()方法检查我们创建的thread线程是否被中断，不会清除中断标志
        System.out.println("thread线程的中断状态（通过isInterrupted()方法）: " + thread.isInterrupted()); // 无sleep输出true 反之输出false，因为thread线程sleep时无法中断

        // 等待thread线程结束
        thread.join();

        // 再次检查thread线程的中断状态，以确认中断标志是否仍被设置
        System.out.println("thread线程的中断状态（再次通过isInterrupted()方法）: " + thread.isInterrupted()); // 输出false或true，取决于线程是否在运行结束后清除了中断标志，但通常这里应该是false，因为线程已经退出

    }

}

