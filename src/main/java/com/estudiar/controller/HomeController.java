package com.estudiar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller class HomeController {

	private ApplicationContext context;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/close")
	public void close() {
		((ConfigurableApplicationContext)context).close();
	}

}
