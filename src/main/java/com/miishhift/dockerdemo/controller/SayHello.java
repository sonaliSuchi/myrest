package com.miishhift.dockerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {

	@Autowired
	Environment env;
	
	@GetMapping("/hello")
	public String sayHello()
	{
	
		String hello="test";
		hello=env.getProperty("hello.test");
		return "Hi!! Your Docker Build pipeline created- "+hello;
	}
}
