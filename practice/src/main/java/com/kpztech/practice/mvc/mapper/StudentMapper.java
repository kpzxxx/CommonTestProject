package com.kpztech.practice.mvc.mapper;

import com.kpztech.practice.mvc.entity.StudentEntity;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

  void insert(StudentEntity studentEntity);

  long uploadImg(@Param("img") byte[] img, @Param("id") Long id, @Param("picName") String picName);

  Long count();

  List<StudentEntity> page(@Param("offset") Integer offset, @Param("limit") Integer limit);

  List<StudentEntity> pageWithGenders(
      @Param("offset") Integer offset, @Param("limit") Integer limit, @Param("genders") Integer[] genders);

  StudentEntity getById(@Param("id") Long id);

}
