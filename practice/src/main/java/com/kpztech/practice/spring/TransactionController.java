package com.kpztech.practice.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
  @Autowired
  private TransactionService transactionService;

  @GetMapping("/test")
  public void test(){
    transactionService.test1();
  }


}
