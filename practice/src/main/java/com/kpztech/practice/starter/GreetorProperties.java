package com.kpztech.practice.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "greetor")
@Data
public class GreetorProperties {
	private String name;
	private String msg;
}
