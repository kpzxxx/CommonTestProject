package com.kpztech.practice.base.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

  public static void main(String[] args) {
    List<Programmer> programmers = Lists.newArrayList();
    CyclicBarrier cyclicBarrier = new CyclicBarrier(20);

    for(int i=0; i<20; i++){
      programmers.add(new Programmer(cyclicBarrier, "Programmer-" + i));
    }

    ExecutorService executor = Executors.newFixedThreadPool(20);
    programmers.forEach(x -> {
      executor.execute(x);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    executor.shutdown();

  }

  private static class Programmer implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private String name;

    Programmer(CyclicBarrier cyclicBarrier, String name) {
      this.cyclicBarrier = cyclicBarrier;
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println(name + "就位");
      try {
        cyclicBarrier.await();
        System.out.println(name + ":" + System.currentTimeMillis());
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

}
