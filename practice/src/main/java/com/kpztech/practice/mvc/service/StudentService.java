package com.kpztech.practice.mvc.service;

import com.kpztech.practice.mvc.entity.StudentEntity;
import com.kpztech.practice.mvc.mapper.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  @Autowired
  private StudentMapper studentMapper;

  public Long count() {
    return studentMapper.count();
  }

  public StudentEntity insert(StudentEntity student) {
    studentMapper.insert(student);
    return student;
  }

  public List<StudentEntity> pageQuery(Integer pageNo, Integer pageSize) {
    int offset = (pageNo - 1) * pageSize;
    int limit = pageSize;
    return studentMapper.page(offset, limit);
  }

}
