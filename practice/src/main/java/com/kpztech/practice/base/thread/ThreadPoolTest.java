package com.kpztech.practice.base.thread;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 3000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
		IntStream.range(0, 10).forEach(x ->
				executor.submit(() -> {
					int i = RandomUtils.nextInt(0, 100);
					try {
						Thread.sleep(i);
						if (i < 50) {
							throw new NullPointerException("i");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + i + ":" + executor.getActiveCount());
				})
		);
		executor.shutdown();
	}
}
