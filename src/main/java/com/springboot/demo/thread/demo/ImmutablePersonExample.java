package com.springboot.demo.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 不可变对象：
 */
public final class ImmutablePersonExample {
    private final String name;
    private final int age;

    public ImmutablePersonExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 注意：没有提供任何可以修改name或age的方法，确保对象不可变


    // 共享的不可变对象
    private static final ImmutablePersonExample SHARED_PERSON = new ImmutablePersonExample("Alice", 30);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 尝试修改不可变对象的属性值（这将不会成功）
        executor.submit(() -> {
            // 尝试修改name，但这将编译失败，因为Person类的name字段是final的
            // SHARED_PERSON.setName("Bob"); // final修饰的变量不能被重新赋值 会报错
            System.out.println("Thread 1: Attempted to modify (failed), current name is " + SHARED_PERSON.getName());
        });

        executor.submit(() -> {
            // 尝试修改age，但这将编译失败，因为Person类的age字段是final的
            // SHARED_PERSON.setAge(31); // final修饰的变量不能被重新赋值   会报错
            System.out.println("Thread 2: Attempted to modify (failed), current age is " + SHARED_PERSON.getAge());
        });

        // 关闭ExecutorService
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}






