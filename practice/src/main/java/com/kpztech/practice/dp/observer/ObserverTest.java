package com.kpztech.practice.dp.observer;

/**
 * 观察者模式
 */
public class ObserverTest {

  public static void main(String[] args) {
    ObserverTest observerTest = new ObserverTest();
    observerTest.test();
  }

  private void test() {
    Watched watched = new Watched();
    Watcher watcher = new Watcher(watched);
    watched.setData("abc");
    watched.setData("def");
    watched.setData("ghi");
  }


}
