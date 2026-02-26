package com.springboot.demo.jvm.demo;

/**
 * 类加载过程: 父类静态-子类静态-父类变量、代码块、构造方法-子类变量、代码块、构造方法-实例方法
 */
public class ClassLoaderExample {
    // 类变量（实例变量）
    private int instanceVariable = instanceMethod();

    // 静态变量
    private static int staticVariable = staticMethod();

    // 常量
    private static final int CONSTANT = 30;

    // 方法
    public int instanceMethod() {
        instanceVariable = staticVariable + 10;
        System.out.println("调用实例方法。。。。。"+instanceVariable);
        return instanceVariable;
    }

    // 静态方法
    public static int staticMethod() {
        staticVariable = CONSTANT + 10; // 静态变量初始化
        System.out.println("调用静态方法。。。。。"+staticVariable);
        return staticVariable;
    }

    // 静态代码块
    static {
        System.out.println("调用静态代码块。。。。"+staticVariable);
    }

    // 代码块
    {
        staticVariable += 10;
        System.out.println("调用代码块。。。。"+staticVariable);
        instanceVariable = staticVariable;
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
    }
}


