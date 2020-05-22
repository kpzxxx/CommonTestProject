package com.kpztech.practice.dp.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Stock {
  private String name = "ABC";
  private int quantity = 10;

  void buy(){
    log.info("Stock 【 Name: {}, Quantity: {} ] bought.", name, quantity);
  }

  void sell(){
    log.info("Stock 【 Name: {}, Quantity: {} ] sold.", name, quantity);
  }

}
