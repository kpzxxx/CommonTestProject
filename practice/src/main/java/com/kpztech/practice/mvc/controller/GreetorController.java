package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.starter.GreetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetor")
public class GreetorController {
	private final GreetorService greetorService;

	@Autowired
	public GreetorController(GreetorService greetorService) {
		this.greetorService = greetorService;
	}


	@GetMapping("/test")
	public ResponseEntity<Object> test() {
		return ResponseEntity.ok(greetorService.greet());
	}
}
