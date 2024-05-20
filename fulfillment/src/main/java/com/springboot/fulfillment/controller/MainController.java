package com.springboot.fulfillment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/home")
	public String goHome() {
		return "home";
	}
	
}
