package com.kpztech.practice.mvc.converter;

import com.kpztech.practice.mvc.entity.StudentEntity;
import com.kpztech.practice.mvc.vo.StudentVO;

import org.springframework.beans.BeanUtils;

public class StudentConverter {
  public static StudentVO convert(StudentEntity entity){
    StudentVO vo = new StudentVO();
    BeanUtils.copyProperties(entity, vo, "pic");
    return vo;
  }

}
