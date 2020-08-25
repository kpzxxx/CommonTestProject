package com.kpztech.practice.designpattern.bridge;

/**
 * 形状抽象，和颜色分离；桥接：形状+颜色(解耦）
 */
public abstract class Shape {

  protected DrawAPI drawAPI;

  protected Shape(DrawAPI drawAPI) {
    this.drawAPI = drawAPI;
  }

  public abstract void draw();
}
