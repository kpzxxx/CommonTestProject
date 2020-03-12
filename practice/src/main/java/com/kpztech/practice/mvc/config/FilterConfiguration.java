package com.kpztech.practice.mvc.config;

import com.google.common.collect.Lists;
import com.kpztech.practice.mvc.filter.TestFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@Configuration
public class FilterConfiguration {
  @Bean
  public FilterRegistrationBean<TestFilter> registerFilter(){
    FilterRegistrationBean<TestFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new TestFilter());
    registrationBean.setUrlPatterns(Lists.newArrayList("/*"));
    registrationBean.setName("TestFilter");
    registrationBean.setOrder(1);
    return registrationBean;
  }

}
