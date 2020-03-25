package com.kpztech.practice.mvc.service;

import com.kpztech.practice.mvc.mapper.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentMapper studentMapper;

  public Long count() {
    return studentMapper.count();
  }

}
