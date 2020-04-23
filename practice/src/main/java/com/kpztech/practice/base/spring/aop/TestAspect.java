package com.kpztech.practice.base.spring.aop;

import com.kpztech.practice.util.KTechDateUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class TestAspect {

  @Pointcut("@annotation(com.kpztech.practice.base.spring.aop.ShowTime)")
  public void showTime() {

  }

  @Pointcut("@within(com.kpztech.practice.base.spring.aop.ShowTime)")
  public void showClassName() {

  }


  @Around("showTime()")
  public Object showTimeAround(ProceedingJoinPoint pjp) throws Throwable {
    long startTime = System.currentTimeMillis();
    log.info("Method[{}] start time: {}", pjp.getSignature().getName(), KTechDateUtils.now());
    Object result = pjp.proceed();
    long endTime = System.currentTimeMillis();
    log.info("Method[{}.{}()] cost time: {} ms", pjp.getSignature().getClass().getName(), pjp.getSignature().getName(),
             (endTime - startTime));
    return result;
  }

}
