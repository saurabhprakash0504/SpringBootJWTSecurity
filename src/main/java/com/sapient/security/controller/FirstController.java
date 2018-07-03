package com.sapient.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {

	
	@GetMapping
	String helloWorldExample() {
		return "Hello World >>> ";
	}
}
