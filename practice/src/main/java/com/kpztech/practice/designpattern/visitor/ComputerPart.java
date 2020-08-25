package com.kpztech.practice.designpattern.visitor;

/**
 * 构件接口
 */
public interface ComputerPart {

  void accept(ComputerPartVisitor visitor);
}
