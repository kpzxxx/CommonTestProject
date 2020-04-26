package com.kpztech.practice.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountDownLatchTest {

  public static void main(String[] args) {
    log.info("CDL start......");
    int threadNum = 5;
    CountDownLatch countDownLatch = new CountDownLatch(threadNum);
    ExecutorService pool = new ThreadPoolExecutor(3, threadNum, 1000, TimeUnit.MILLISECONDS,
                                                  new ArrayBlockingQueue<>(1000), new ThreadPoolExecutor.AbortPolicy());

    for (int i = 0; i < threadNum; i++) {
      pool.submit(() -> {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          log.info("{} handle complete.....", Thread.currentThread().getName());
          countDownLatch.countDown();
        }
      });
    }

    try {
      countDownLatch.await(15, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    log.info("CDL ended......");
    pool.shutdown();
  }

}
