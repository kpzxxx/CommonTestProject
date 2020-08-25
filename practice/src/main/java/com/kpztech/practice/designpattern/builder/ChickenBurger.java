package com.kpztech.practice.designpattern.builder;

public class ChickenBurger extends Burger {

  @Override
  public String name() {
    return "Chicken Burger";
  }

  @Override
  public float price() {
    return 30.0F;
  }
}
