package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
  @Autowired
  private StudentService studentService;

  @RequestMapping("/count")
  public Long count(){
    return studentService.count();
  }

}
