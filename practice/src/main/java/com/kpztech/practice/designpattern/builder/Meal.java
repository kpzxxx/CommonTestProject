package com.kpztech.practice.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Meal {

  private List<Item> items = new ArrayList<>();

  public void addItem(Item item) {
    items.add(item);
  }

  public float getCost() {
    float cost = 0.0F;
    for (Item item : items) {
      cost += item.price();
    }
    return cost;
  }

  public void showItems() {
    for (Item item : items) {
      log.info("Item : {}, Packing : {}, Price : {}", item.name(), item.packing(), item.price());
    }
  }

}
