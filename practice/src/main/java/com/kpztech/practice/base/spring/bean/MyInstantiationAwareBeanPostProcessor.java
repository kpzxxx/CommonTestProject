package com.kpztech.practice.base.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import javax.annotation.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

  /**
   * 设置属性前调用
   */
  @Override
  public Object postProcessBeforeInitialization(@Nullable Object bean, String beanName) throws BeansException {
    log.info("InstantiationAwareBeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");

    if (bean instanceof Person) {
      ((Person) bean).setName("ABC-Before");
    }

    return bean;
  }

  /**
   * 设置属性后调用
   */
  @Override
  public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) throws BeansException {
    log.info("InstantiationAwareBeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");

    if (bean instanceof Person) {
      ((Person) bean).setName("ABC-After");
    }
    return bean;
  }

  /**
   * 设置属性时调用
   */
  @Override
  public PropertyValues postProcessProperties(PropertyValues pvs, @Nullable Object bean, String beanName)
      throws BeansException {
    log.info("InstantiationAwareBeanPostProcessor接口方法postProcessProperties对属性进行更改！");
    return pvs;
  }

}
