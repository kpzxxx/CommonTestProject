package com.kpztech.practice.test.test1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 用多线程实现一个生产者和消费者模式。一个线程负责往Map里put 1-100的数字，另外一个线程负责get数字并进行累加，并打印结果。
 */
public class Test1 {

    private static ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ProviderThread providerThread = new ProviderThread(map);
        ConsumerThread consumerThread = new ConsumerThread(map);
        providerThread.start();
        consumerThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
