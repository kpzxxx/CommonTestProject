package com.kpztech.practice.base.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

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

    String
        taskName =
        "Method[" + pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName() + "()]";
    StopWatch stopWatch = new StopWatch(taskName);
    stopWatch.start();
    Object result = pjp.proceed();
    stopWatch.stop();
    log.info(stopWatch.shortSummary());
    return result;
  }

}
