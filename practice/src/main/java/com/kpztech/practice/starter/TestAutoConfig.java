package com.kpztech.practice.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GreetorProperties.class)
@ConditionalOnClass(GreetorService.class)
public class TestAutoConfig {
	private final GreetorProperties properties;

	public TestAutoConfig(GreetorProperties properties) {
		this.properties = properties;
	}

	@Bean
	@ConditionalOnMissingBean(GreetorService.class)
	public GreetorService greetorService(){
		return new GreetorService(properties);
	}
}
