package com.kpztech.practice.designpattern.command;

import com.google.common.collect.Lists;

import java.util.List;

class Broker {

  private List<Order> orders = Lists.newArrayList();

  // 添加命令
  void takeOrder(Order order) {
    orders.add(order);
  }

  // 执行命令
  void placeOrders() {
    for (Order order : orders) {
      order.execute();
    }
    orders.clear();
  }

}
