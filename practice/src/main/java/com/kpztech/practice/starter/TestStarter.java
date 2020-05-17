package com.kpztech.practice.starter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TestAutoConfig.class)
@ComponentScan("com.kpztech.practice.starter")
public @interface TestStarter {
}
