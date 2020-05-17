package com.kpztech.practice.starter;

public class GreetorService {
	private GreetorProperties properties;

	public GreetorService() {
	}

	public GreetorService(GreetorProperties properties) {
		this.properties = properties;
	}

	public String greet() {
		return "Greet by " + properties.getName() + ", msg: " + properties.getMsg();
	}
}
