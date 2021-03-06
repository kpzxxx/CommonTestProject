package com.kpztech.practice.boot.mvc.config;

import com.kpztech.practice.boot.mvc.interceptor.TestInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

  @Autowired
  private TestInterceptor testInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(testInterceptor).addPathPatterns("/**");
  }
}
