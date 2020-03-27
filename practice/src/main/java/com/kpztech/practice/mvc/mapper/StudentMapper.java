package com.kpztech.practice.mvc.mapper;

import com.kpztech.practice.mvc.entity.StudentEntity;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

  void insert(StudentEntity studentEntity);

  Long count();

  List<StudentEntity> page(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
