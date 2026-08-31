package com.springboot.demo.thread.demo;

/**
 * 双重检验锁实现单例模式
 */
public class SingletonExample {
        // 使用volatile关键字：多线程情况下禁止指令重排，保证实例的正常创建
        private static volatile SingletonExample instance;

        // 私有构造函数，防止外部实例化
        private SingletonExample() {}

        // 提供一个全局访问点
        public static SingletonExample getInstance() {
            // 第一次检查：如果实例已经存在，则直接返回，提升了性能
            if (instance == null) {
                // 同步块，保证线程安全
                synchronized (SingletonExample.class) {
                    // 第二次检查：避免多线程情况下的重复创建
                    if (instance == null) {
                        instance = new SingletonExample();
                    }
                }
            }
            return instance;
        }
    }

