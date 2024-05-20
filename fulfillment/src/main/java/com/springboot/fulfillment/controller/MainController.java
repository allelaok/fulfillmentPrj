package com.springboot.fulfillment.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.fulfillment.data.dto.GoodsCreateDTO;
import com.springboot.fulfillment.service.GoodsService;

@Controller
public class MainController {
	@Autowired
	private GoodsService goodsService;

	@GetMapping("/home")
	public String goHome() {
		return "home";
	}

	
	
	
}
