package com.springboot.fulfillment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.fulfillment.data.dto.OrdersRequestDTO;
import com.springboot.fulfillment.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping("/{id}")
	public ModelAndView getOrderList(@PathVariable("id") String id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("orders/list");
		modelAndView.addObject("list", ordersService.getOrderList(id));
		return modelAndView;
	}

	// void => 수행하는 주체에 따라서 이동하는 페이지 설정
	@PostMapping
	public void addOrder(@RequestBody OrdersRequestDTO ordersRequestDTO) {
		ordersService.addOrder(ordersRequestDTO);
	}

	// void => 수행하는 주체에 따라서 이동하는 페이지 설정
	@PutMapping("/{id}") // orderid
	public void changeOrderStatus(@PathVariable("id") String id) throws Exception {
		ordersService.changeOrderStatus(id);
	}
}
