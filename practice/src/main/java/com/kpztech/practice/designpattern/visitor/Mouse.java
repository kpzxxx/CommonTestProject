package com.kpztech.practice.designpattern.visitor;

/**
 * 构件
 */
public class Mouse implements ComputerPart{

  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visit(this);
  }
}
