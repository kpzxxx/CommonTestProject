package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.base.spring.aop.ShowTime;
import com.kpztech.practice.mvc.common.CommonResponse;
import com.kpztech.practice.mvc.common.ResponseEnum;
import com.kpztech.practice.mvc.converter.StudentConverter;
import com.kpztech.practice.mvc.entity.StudentEntity;
import com.kpztech.practice.mvc.service.StudentService;
import com.kpztech.practice.mvc.vo.StudentVO;
import com.kpztech.practice.util.FileUtils;

import org.apache.commons.lang3.StringUtils;
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

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/count")
  public CommonResponse<Long> count() {
    Long count = studentService.count();
    return CommonResponse.of(count);
  }

  @PostMapping("/insert")
  public ResponseEntity<CommonResponse<StudentVO>> insert(@RequestBody StudentEntity student) {
    StudentEntity result = studentService.insert(student);
    StudentVO studentVO = StudentConverter.convert(result);
    return ResponseEntity.ok(CommonResponse.of(studentVO));
  }

  @PostMapping("/img/{id}")
  public ResponseEntity<CommonResponse<Object>> uploadImg(@RequestParam MultipartFile pic, @PathVariable Long id) {
    try {
      studentService.uploadImg(pic, id);
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.ok(CommonResponse.of(ResponseEnum.STUDENT_IMG_UPLOAD_ERROR));
    }
    return ResponseEntity.ok(CommonResponse.of(ResponseEnum.SUCCESS));
  }

  @GetMapping("/img/{id}")
  public ResponseEntity<CommonResponse<Object>> getImg(@PathVariable Long id, HttpServletResponse response) {
    StudentEntity student = studentService.getStudent(id);

    if (StringUtils.isBlank(student.getPicName()) || student.getPic() == null || student.getPic().length == 0) {
      return ResponseEntity.ok(CommonResponse.of(ResponseEnum.STUDENT_NO_PIC));
    }
    String downloadName = student.getName() + FileUtils.getFileSuffix(student.getPicName());

    FileUtils.download(response, downloadName, student.getPic());

    return ResponseEntity.ok(CommonResponse.of(ResponseEnum.SUCCESS));
  }

  @GetMapping("/page")
  @ShowTime
  public ResponseEntity<CommonResponse<List<StudentVO>>> getPaged(
      @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize) {
    List<StudentEntity> studentEntities = studentService.pageQuery(pageNo, pageSize);
    List<StudentVO> result = studentEntities.stream().map(StudentConverter::convert).collect(Collectors.toList());
    return ResponseEntity.ok(CommonResponse.of(result));
  }

  @GetMapping("/pageWithTest")
  public ResponseEntity<CommonResponse<List<StudentVO>>> pageQueryWithTest(
      @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize) {
    List<StudentEntity> studentEntities = studentService.pageQueryWithTest(pageNo, pageSize, 1, 2);
    List<StudentVO> result = studentEntities.stream().map(StudentConverter::convert).collect(Collectors.toList());
    return ResponseEntity.ok(CommonResponse.of(result));
  }

}
