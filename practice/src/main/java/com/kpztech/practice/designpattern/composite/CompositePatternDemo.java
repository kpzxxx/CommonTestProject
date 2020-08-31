package com.kpztech.practice.designpattern.composite;

import org.springframework.util.CollectionUtils;

/**
 * 组合模式:部分-整体，树形结构
 */
public class CompositePatternDemo {

  public static void main(String[] args) {
    Employee CEO = new Employee("John", "CEO", 30000);
    Employee headSales = new Employee("Robert", "Head Sale", 20000);
    Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
    Employee clerk1 = new Employee("Laura", "Marketing", 10000);
    Employee clerk2 = new Employee("Bob", "Marketing", 10000);

    Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
    Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

    CEO.add(headSales);
    CEO.add(headMarketing);

    headMarketing.add(clerk1);
    headMarketing.add(clerk2);

    headSales.add(salesExecutive1);
    headSales.add(salesExecutive2);

    System.out.println(CEO);
    if (!CollectionUtils.isEmpty(CEO.getSubordinates())) {
      CEO.getSubordinates().forEach(x -> {
        System.out.println(x);
        if (!CollectionUtils.isEmpty(x.getSubordinates())) {
          x.getSubordinates().forEach(System.out::println);
        }
      });
    }

  }
}
