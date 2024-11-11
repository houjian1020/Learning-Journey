package com.springboot.demo.jvm.demo;

/**
 * 类加载过程
 */
public class ClassLoaderExample {
    // 类变量（实例变量）
    private int instanceVariable;

    // 静态变量
    private static int staticVariable;

    // 常量
    private static final int CONSTANT = 30;

    // 方法
    public void instanceMethod() {
        instanceVariable = 60;
        System.out.println("调用实例方法。。。。。"+instanceVariable);
    }

    // 静态方法
    public static void staticMethod() {
        staticVariable = 40; // 静态变量初始化
        System.out.println("调用静态方法。。。。。"+staticVariable);
    }

    // 静态代码块
    static {
        System.out.println("调用静态代码块。。。。"+staticVariable);
    }

    // 构造器
    public ClassLoaderExample() {
        System.out.println("调用构造函数。。。。。"+instanceVariable);
    }

    public static void main(String[] args) {
        //触发Example类的加载、连接和初始化
        ClassLoaderExample example = new ClassLoaderExample();

        // 调用实例方法和静态方法
        example.instanceMethod();
        ClassLoaderExample.staticMethod();
    }
}


