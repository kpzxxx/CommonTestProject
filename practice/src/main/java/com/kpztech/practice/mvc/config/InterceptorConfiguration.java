package com.kpztech.practice.mvc.config;

import com.kpztech.practice.mvc.interceptor.TestInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

  @Autowired
  private TestInterceptor testInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(testInterceptor).addPathPatterns("/**");
  }
}
