package com.kpztech.practice.designpattern.builder;

public class Pepsi extends ColdDrink {

  @Override
  public String name() {
    return "Pepsi";
  }

  @Override
  public float price() {
    return 35.0F;
  }
}
