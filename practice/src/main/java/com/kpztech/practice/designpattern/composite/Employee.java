package com.kpztech.practice.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Employee {
  private String name;
  private String dept;
  private int salary;
  private List<Employee> subordinates;

  public Employee(String name, String dept, int sal){
    this.name = name;
    this.dept = dept;
    this.salary = sal;
    subordinates = new ArrayList<>();
  }

  public void add(Employee e){
    subordinates.add(e);
  }

  public void remove(Employee e){
    subordinates.remove(e);
  }

  @Override
  public String toString(){
    return ("Employee :[ Name : "+ name
            +", dept : "+ dept + ", salary :"
            + salary+" ]");
  }

}
