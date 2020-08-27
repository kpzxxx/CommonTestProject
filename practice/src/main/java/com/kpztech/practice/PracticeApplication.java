package com.kpztech.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ServletComponentScan("com.kpztech.practice.boot.mvc")
@MapperScan("com.kpztech.practice.boot.mvc.mapper")
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.kpztech.practice.starter.*"))
@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy = true)
public class PracticeApplication {

  public static void main(String[] args) {
    SpringApplication.run(PracticeApplication.class, args);
  }

}
