package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.converter.StudentConverter;
import com.kpztech.practice.mvc.entity.StudentEntity;
import com.kpztech.practice.mvc.service.StudentService;
import com.kpztech.practice.mvc.vo.StudentVO;
import com.kpztech.practice.util.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

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
  public ResponseEntity<StudentVO> insert(@RequestBody StudentEntity student) {
    StudentEntity result = studentService.insert(student);
    return ResponseEntity.ok(StudentConverter.convert(result));
  }

  @PostMapping("/img")
  public ResponseEntity<Boolean> uploadImg(@RequestParam MultipartFile pic, @RequestParam Long id) {
    boolean result = true;
    try {
      studentService.uploadImg(pic, id);
    } catch (IOException e) {
      e.printStackTrace();
      result = false;
    }
    return ResponseEntity.ok(result);
  }

  @GetMapping("img")
  public ResponseEntity<Boolean> getImg(@RequestParam Long id, HttpServletResponse response) {
    StudentEntity student = studentService.getStudent(id);

    // TODO 通过文件名和byte[]生成文件,放到/tmp文件夹里。

    String filePath = "/Users/q/Desktop/jmeter/test/";
    String fileName = "blob.jpeg";

    String downloadName = student.getName() + FileUtils.getFileSuffix(fileName);

    FileUtils.download(response, fileName, filePath, downloadName);

//    FileUtils.delete(fileName, filePath);

    return ResponseEntity.ok(true);
  }

  @GetMapping("/page")
  public ResponseEntity<List<StudentVO>> getPaged(
      @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize) {
    List<StudentEntity> studentEntities = studentService.pageQuery(pageNo, pageSize);
    List<StudentVO> result = studentEntities.stream().map(StudentConverter::convert).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/pageWithTest")
  public ResponseEntity<List<StudentVO>> pageQueryWithTest(
      @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize) {
    List<StudentEntity> studentEntities = studentService.pageQueryWithTest(pageNo, pageSize);
    List<StudentVO> result = studentEntities.stream().map(StudentConverter::convert).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

}
