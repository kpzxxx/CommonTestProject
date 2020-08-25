package com.kpztech.practice.boot.mvc.controller;

import com.kpztech.practice.boot.mvc.service.SingService;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sing")
@Scope("request")
public class SingController {

  private final SingService singService;

  public SingController(SingService singService) {
    this.singService = singService;
  }

  @RequestMapping("/sing")
  public String sing(){
    return singService.sing();
  }

  @RequestMapping("/getBean")
  public String getBean(){
    return singService.getBean();
  }

}
