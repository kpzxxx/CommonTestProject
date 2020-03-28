package com.kpztech.practice.base.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(@Nullable Object bean, String beanName) throws BeansException {
    log.info("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");

    if(bean instanceof Person){
      ((Person) bean).setName("ABC-Before");
    }

    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) throws BeansException {
    log.info("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");

    if(bean instanceof Person){
      ((Person) bean).setName("ABC-After");
    }
    return bean;
  }
}
