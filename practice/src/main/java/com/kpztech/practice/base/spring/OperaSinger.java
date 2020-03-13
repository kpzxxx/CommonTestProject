package com.kpztech.practice.base.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class OperaSinger implements Singer {

//  @PostConstruct
  public void init(){
    System.out.println("Me, Opera Singer is running now!");
  }

//  @PreDestroy
  public void destroy(){
    System.out.println("Oh no, Opera Singer is dead.");
  }

  @Override
  public String sing() {
    return "Opera singer.";
  }
}
