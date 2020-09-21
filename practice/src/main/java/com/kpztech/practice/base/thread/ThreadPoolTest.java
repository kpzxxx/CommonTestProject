package com.kpztech.practice.base.thread;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolTest t = new ThreadPoolTest();
		t.test1();
		System.out.println("-------------------------");
		t.test2();
		System.out.println("-------------------------");
		t.test3();
	}

	/**
	 * 异常处理：通过ThreadFactory:Thread:setUncaughtExceptionHandler()
	 */
	public void test1() {
		ThreadFactory threadFactory = r -> {
			Thread t = new Thread(r);
			t.setUncaughtExceptionHandler((t1, e) -> System.out.println(t1.getName() + ":" + e.toString()));
			return t;
		};
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 3000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(5), threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());

		execute(executor);
	}

	/**
	 * 异常处理：通过Future.get()来做
	 */
	public void test2() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 3000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardOldestPolicy());

		IntStream.range(0, 10).forEach(x -> {
					Future<?> future = executor.submit(() -> {
						int i = RandomUtils.nextInt(0, 100);
						try {
							Thread.sleep(i);
							if (i < 50) {
								// 怎么把这个异常传递给主线程？
								throw new NullPointerException(i + "");
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ":" + i + ":" + executor.getActiveCount());
					});
					try {
						future.get();
					} catch (InterruptedException | ExecutionException e) {
						System.out.println(e.getMessage());
					}
				}

		);

		executor.shutdown();
	}

	/**
	 *
	 */
	public void test3() {
		ThreadPoolExecutor executor = new MyExecutor(1, 5, 3000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(5));

		execute(executor);
	}

	private void execute(ThreadPoolExecutor executor) {
		IntStream.range(0, 10).forEach(x ->
				executor.execute(() -> {
					int i = RandomUtils.nextInt(0, 100);
					try {
						Thread.sleep(i);
						if (i < 50) {
							// 怎么把这个异常传递给主线程？
							throw new NullPointerException(String.valueOf(i));
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + i + ":" + executor.getActiveCount());
				})
		);

		executor.shutdown();
	}


	private static class MyExecutor extends ThreadPoolExecutor {
		public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		}

		@Override
		protected void afterExecute(Runnable r, Throwable t) {
			super.afterExecute(r, t);
			if (t != null) {
					System.out.println(t.toString());
			}
		}
	}
}
