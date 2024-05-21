package com.springboot.fulfillment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.fulfillment.data.dto.OrderListResponseDTO;
import com.springboot.fulfillment.data.entity.Orders;
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

	//entity => dto로 수정
	//void => 수행하는 주체에 따라서 이동하는 페이지 설정
    @PostMapping
    public void addOrder(@RequestBody Orders order) {
    	System.out.println(order.toString());
    	ordersService.addOrder(order);
    	
    	
    }
    
    //entity => dto로 수정
  	//void => 수행하는 주체에 따라서 이동하는 페이지 설정
    @PutMapping("/{id}")//orderid
    public void changeOrderStatus(@PathVariable("id") String id) throws Exception {
    	ordersService.changeOrderStatus(id);
    	
//        return updatedOrder != null ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
    }
}
