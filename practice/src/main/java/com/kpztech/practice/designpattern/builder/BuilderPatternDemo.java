package com.kpztech.practice.designpattern.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderPatternDemo {

  public static void main(String[] args) {
    MealBuilder mealBuilder = new MealBuilder();

    Meal vegMeal = mealBuilder.prepareVegMeal();
    log.info("Veg Meal");
    vegMeal.showItems();
    log.info("Total cost: {}", vegMeal.getCost());

    Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
    log.info("Non-Veg Meal");
    nonVegMeal.showItems();
    log.info("Total cost: {}", nonVegMeal.getCost());
  }

}
