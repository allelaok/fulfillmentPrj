package com.springboot.fulfillment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.fulfillment.service.GoodsService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@Autowired
	private GoodsService goodsService;

	@GetMapping("/home")
	public String goHome() {
		return "home";
	}

	
	
	
}
