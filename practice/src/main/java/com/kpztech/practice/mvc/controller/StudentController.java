package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.common.CommonResponse;
import com.kpztech.practice.mvc.common.ResponseEnum;
import com.kpztech.practice.mvc.converter.StudentConverter;
import com.kpztech.practice.mvc.entity.StudentEntity;
import com.kpztech.practice.mvc.service.StudentService;
import com.kpztech.practice.mvc.vo.StudentVO;
import com.kpztech.practice.util.FileUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @PostMapping("/img/{id}")
  public ResponseEntity<Boolean> uploadImg(@RequestParam MultipartFile pic, @PathVariable Long id) {
    boolean result = true;
    try {
      studentService.uploadImg(pic, id);
    } catch (IOException e) {
      e.printStackTrace();
      result = false;
    }
    return ResponseEntity.ok(result);
  }

  @GetMapping("/img/{id}")
  public ResponseEntity<CommonResponse> getImg(@PathVariable Long id, HttpServletResponse response) {
    StudentEntity student = studentService.getStudent(id);

    if (StringUtils.isBlank(student.getPicName()) || student.getPic() == null || student.getPic().length == 0) {
      return ResponseEntity.ok(CommonResponse.of(ResponseEnum.SUCCESS));
    }
    String downloadName = student.getName() + FileUtils.getFileSuffix(student.getPicName());

    FileUtils.download(response, downloadName, student.getPic());

    return ResponseEntity.ok(CommonResponse.of(ResponseEnum.STUDENT_NO_PIC));
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
