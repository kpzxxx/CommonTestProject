package com.kpztech.practice.mvc.service;

import com.kpztech.practice.base.spring.OperaSinger;
import com.kpztech.practice.base.spring.Singer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SingService implements ApplicationContextAware {

  @Resource
  private Singer operaSinger;

  private ApplicationContext applicationContext;


  public String sing() {
    return operaSinger.sing();
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  public String getBean() {
    return applicationContext.getBean(OperaSinger.class).getClass().getName();
  }
}
