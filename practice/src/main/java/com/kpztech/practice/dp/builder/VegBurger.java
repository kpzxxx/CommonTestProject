package com.kpztech.practice.dp.builder;

public class VegBurger extends Burger {

  @Override
  public String name() {
    return "Veg Burger";
  }

  @Override
  public float price() {
    return 25.0F;
  }
}
