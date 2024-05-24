package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.OrdersDTO;
import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("OrderService")
public class OrdersService {

	private final OrdersRepository ordersRepository;

	@Autowired
	public OrdersService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}

	public List<OrdersDTO> orderList(Integer status) throws Exception {
		List<OrdersDTO> orderList = new ArrayList<>();
		List<Orders> result = ordersRepository.findAllByStatus(status);
		for (Orders order : result) {
		}

		return null;
	}
}
