package com.kpztech.practice.base.java;

public class A {
  public void test(){
    System.out.println("A");
  }

}

class B extends A{
  @Override
  public void test(){
    System.out.println("B");
  }

}

class C extends B{
  @Override
  public void test(){
    System.out.println("C");
  }
}

class Test {
  public static void main(String[] args) {
//    A a = new A();
//    A b = new B();
//    A c = new C();
//    a.test();
//    b.test();
//    c.test();
//    System.out.println(a instanceof A);
//    System.out.println(b instanceof A);
//    System.out.println(b instanceof A);
//    System.out.println(b instanceof B);
//    System.out.println(c instanceof C);
//    System.out.println(c.getClass().getName());

    AI ai = new AI();
    ai.test();
    System.out.println(ai instanceof AI1);
    System.out.println(ai instanceof AI2);
    System.out.println(ai instanceof AI3);
  }
}


interface AI1{
  default void test(){
    System.out.println("AI1");
  }
}

interface AI2{
  default void test(){
    System.out.println("AI2");
  }
}

interface AI3 extends AI1, AI2{
  default void test(){
    System.out.println("AI3");
  }
}

class AI implements AI3{

  @Override
  public void test() {
    System.out.println("AI");
  }
}
