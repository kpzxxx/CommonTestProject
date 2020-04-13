package com.kpztech.practice.dp.visitor;

/**
 * 构件对应的访问者接口
 */
public interface ComputerPartVisitor {

  void visit(Keyboard keyboard);

  void visit(Mouse mouse);

  void visit(Monitor monitor);

  void visit(Computer computer);
}
