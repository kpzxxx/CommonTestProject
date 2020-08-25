package com.kpztech.practice.designpattern.observer;


import java.util.Observable;

import lombok.Getter;

/**
 * java支持：Observable 被观察者
 */
public class Watched extends Observable {

  @Getter
  private String data = "";

  public void setData(String data) {
    if (!this.data.equals(data)) {
      this.data = data;
      setChanged();
    }
    notifyObservers();
  }


}
