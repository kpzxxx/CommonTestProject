package com.kpztech.practice.dp.visitor;

/**
 * 构件接口
 */
public interface ComputerPart {

  void accept(ComputerPartVisitor visitor);
}
