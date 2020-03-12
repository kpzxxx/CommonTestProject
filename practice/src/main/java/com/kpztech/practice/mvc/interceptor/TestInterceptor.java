package com.kpztech.practice.mvc.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class TestInterceptor implements HandlerInterceptor {

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("Pre Handle!");
    return true;
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                   @Nullable ModelAndView modelAndView) throws Exception {
    System.out.println("PostHandle!");
  }

  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                        @Nullable Exception ex) throws Exception {
    System.out.println("After completion!");
  }

}
