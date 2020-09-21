package com.kpztech.practice.algorithm.bytedance;

/**
 * 用synchronized 2个线程循环打印1-100
 */
public class BD2 {
	private static volatile Integer n = 1;
	private static final Object object = new Object();

	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread1();
		Thread t3 = new MyThread1();
		t1.setName("T1");
		t2.setName("T2");
		t3.setName("T3");
		t1.start();
		t2.start();
		t3.start();
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
