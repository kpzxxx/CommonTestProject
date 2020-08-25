package com.kpztech.practice.designpattern.visitor;

/**
 * 整体、构件定义
 */
public class Computer implements ComputerPart {

  ComputerPart[] parts;

  public Computer(){
    parts = new ComputerPart[] { new Mouse(),new Keyboard(),new Monitor()};
  }

  @Override
  public void accept(ComputerPartVisitor visitor) {
    for(ComputerPart computerPart : parts){
      computerPart.accept(visitor);
    }
    visitor.visit(this);
  }
}
