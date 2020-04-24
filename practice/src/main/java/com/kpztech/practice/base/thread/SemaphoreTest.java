package com.kpztech.practice.base.thread;

import com.kpztech.practice.util.KTechDateUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SemaphoreTest {

  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(3);
    ExecutorService pool = Executors.newFixedThreadPool(100);
    for (int i = 0; i < 10; i++) {

      Runnable thread = () -> {
        try {
          semaphore.acquire();
          log.info(KTechDateUtils.now());
          Thread.sleep(1000);


        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }

      };
      pool.submit(thread);

    }

    pool.shutdown();
  }

}
