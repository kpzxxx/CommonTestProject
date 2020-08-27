package com.kpztech.practice.spring;

import com.kpztech.practice.boot.mvc.common.StudentGenderEnum;
import com.kpztech.practice.boot.mvc.entity.StudentEntity;
import com.kpztech.practice.boot.mvc.service.StudentService;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

  private static final String PHONE = "13298462874";

  @Autowired
  private StudentService studentService;

  /**
   * 自己调自己的方法，必须走代理，不然事务不生效。
   *  ((TransactionService) AopContext.currentProxy()).test2(); 要和
   *  "@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy = true)" 配合使用
   */
  @Transactional
  public void test1() {
    ((TransactionService) AopContext.currentProxy()).test2();
    test3();
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void test2() {
    studentService.delete(PHONE);

  }

  private void test3() {
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setGender(StudentGenderEnum.FEMALE.getGender());
    studentEntity.setName("Ryo");
    studentEntity.setPhone(PHONE);
    studentService.insert(studentEntity);
//    throw new RuntimeException("TEST");

  }


}
