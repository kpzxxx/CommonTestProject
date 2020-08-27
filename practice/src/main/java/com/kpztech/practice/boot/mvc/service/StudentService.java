package com.kpztech.practice.boot.mvc.service;

import com.kpztech.practice.boot.mvc.entity.StudentEntity;
import com.kpztech.practice.boot.mvc.mapper.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

  public void uploadImg(MultipartFile pic, Long id) throws IOException {
    studentMapper.uploadImg(pic.getBytes(), id, pic.getOriginalFilename());
  }

  public List<StudentEntity> pageQuery(Integer pageNo, Integer pageSize) {
    int offset = (pageNo - 1) * pageSize;
    int limit = pageSize;
    return studentMapper.page(offset, limit);
  }

  public List<StudentEntity> pageQueryWithTest(Integer pageNo, Integer pageSize, Integer... genders) {
    int offset = (pageNo - 1) * pageSize;
    int limit = pageSize;
    return studentMapper.pageWithGenders(offset, limit, genders);
  }

  public StudentEntity getStudent(Long id) {
    return studentMapper.getById(id);
  }

  public void delete(String phone){
    studentMapper.deleteByPhone(phone);
  }

}
