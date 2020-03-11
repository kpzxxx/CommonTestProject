package com.kpztech.practice.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

  @RequestMapping("/test")
  public String test(){
    return "success!";
  }

}
