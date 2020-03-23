package com.kpztech.practice.dp.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * java支持：Observer 观察者
 */
public class Watcher implements Observer {

  Watcher(Observable o) {
    o.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    System.out.println("State changed: " + ((Watched) o).getData());
  }
}
