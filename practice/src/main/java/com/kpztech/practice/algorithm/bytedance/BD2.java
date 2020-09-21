package com.kpztech.practice.algorithm.bytedance;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用synchronized 2个线程循环打印1-100
 * TODO 用ReentrantLock实现，如果有5个线程循环打印呢？
 */
public class BD2 {
	private static volatile Integer n = 1;
	private static final Object object = new Object();

	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread1();

		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();

		// 如果有3个，notify和notifyAll已不能满足要求。通过Condition唤醒？
//		Thread t3 = new MyThread1();
//		t3.setName("T3");
//		t3.start();

		ReentrantLock lock = new ReentrantLock();
		Condition c1 = lock.newCondition();
		lock.lock();
	}

	private static class MyThread1 extends Thread {
		public void run() {
			while (n <= 100) {
				synchronized (object) {
					try {
						object.notifyAll();
						System.out.println(Thread.currentThread().getName() + ":" + n++);
						// 最后一次不wait
						if (n < 101) {
							object.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
