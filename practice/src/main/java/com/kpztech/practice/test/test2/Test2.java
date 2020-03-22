package com.kpztech.practice.test.test2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现两个线程，使之交替打印1-100,如：两个线程分别为：Printer1和Printer2,最后输出结果为： Printer1 — 1 Printer2 一 2 Printer1 一 3 Printer2 一 4。
 */
public class Test2 {
    private static AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (num.get() < 100) {
                if (num.get() % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "-" + num);
                    num.addAndGet(1);
                }
            }
        });
        thread1.setName("Printer1");
        Thread thread2 = new Thread(() -> {
            while (num.get() <= 100) {
                if (num.get() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-" + num);
                    num.addAndGet(1);
                }
            }
        });
        thread2.setName("Printer2");

        thread1.start();
        thread2.start();

    }
}
