package com.kpztech.practice.dp.command;

public class BuyStock implements Order {
  private Stock abcStock;

  BuyStock(Stock abcStock) {
    this.abcStock = abcStock;
  }

  @Override
  public void execute() {
    abcStock.buy();
  }
}
