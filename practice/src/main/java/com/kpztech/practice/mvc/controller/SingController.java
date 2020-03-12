package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.service.SingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sing")
@Scope("request")
public class SingController {

  @Autowired
  private SingService singService;

  @RequestMapping("/sing")
  public String sing(){
    return singService.sing();
  }

  @RequestMapping("/getBean")
  public String getBean(){
    return singService.getBean();
  }

}
