package com.kpztech.practice.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 3000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(1000), new ThreadPoolExecutor.AbortPolicy());
	}
}
