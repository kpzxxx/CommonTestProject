package com.kpztech.practice.test.test1;

import java.util.concurrent.ConcurrentHashMap;

public class ProviderThread extends Thread {
    private ConcurrentHashMap<Object, Object> concurrentMap;

    public ProviderThread(ConcurrentHashMap<Object, Object> concurrentMap) {
        this.concurrentMap = concurrentMap;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            concurrentMap.put(i, "");
        }
    }
}
