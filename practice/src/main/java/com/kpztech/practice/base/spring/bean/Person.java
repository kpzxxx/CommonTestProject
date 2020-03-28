package com.kpztech.practice.base.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
  private String name;
  private String address;
  private String phone;

  private BeanFactory beanFactory;
  private String beanName;

  public Person(){
    log.info("【构造器】调用Person的构造器实例化");
  }

  public void setName(String name){
    log.info("【注入属性】注入属性name");
    this.name = name;
  }

  @Override
  public void setBeanFactory(@Nullable BeanFactory beanFactory) throws BeansException {
    log.info("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
    this.beanFactory = beanFactory;
  }

  @Override
  public void setBeanName(@Nullable String name) {
    log.info("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
    this.beanName = name;
  }

  @Override
  public void destroy() {
    log.info("【DisposableBean接口】调用DisposableBean.destroy()");
  }

  @Override
  public void afterPropertiesSet() {
    log.info("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
  }

  @PreDestroy
  public void preDestroy(){
    log.info("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
  }

  @PostConstruct
  public void postConstruct(){
    log.info("【init-method】调用<bean>的init-method属性指定的初始化方法");
  }
}
