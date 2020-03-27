package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.entity.StudentEntity;
import com.kpztech.practice.mvc.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/count")
  public ResponseEntity<Long> count() {
    return ResponseEntity.ok(studentService.count());
  }

  @PostMapping("/insert")
  public ResponseEntity<StudentEntity> insert(@RequestBody StudentEntity student) {
    StudentEntity result = studentService.insert(student);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/page")
  public ResponseEntity<List<StudentEntity>> getPaged(@RequestParam(defaultValue = "1") Integer pageNo,
                                                @RequestParam(defaultValue = "20") Integer pageSize){
    List<StudentEntity> studentEntities = studentService.pageQuery(pageNo, pageSize);
    return ResponseEntity.ok(studentEntities);
  }

}
