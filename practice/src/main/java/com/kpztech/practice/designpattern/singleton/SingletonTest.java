package com.kpztech.practice.designpattern.singleton;

/**
 * 双重检查的单例模式
 */
public class SingletonTest {
    private static SingletonTest singletonTest;

    private SingletonTest() {

    }

    public static SingletonTest getInstance() {
        // 防止调用new方法2次
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                if (singletonTest == null) {
                    singletonTest = new SingletonTest();
                }
            }
        }
        return singletonTest;
    }
}
