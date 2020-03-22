package com.kpztech.practice.test.test1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerThread extends Thread {

    private ConcurrentHashMap<Object, Object> concurrentMap;
    private AtomicInteger integer = new AtomicInteger(0);

    public ConsumerThread(ConcurrentHashMap<Object, Object> concurrentMap) {
        this.concurrentMap = concurrentMap;
    }

    @Override
    public void run() {
        while (!concurrentMap.isEmpty()) {
            for (Object ele : concurrentMap.keySet()) {
                int intValue = (Integer) ele;
                System.out.println(integer.addAndGet(intValue));
                concurrentMap.remove(ele);
            }
        }
    }
}
