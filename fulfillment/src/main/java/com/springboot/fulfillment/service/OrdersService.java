package com.springboot.fulfillment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.OrdersRepository;

@Service
public class OrdersService {
	 @Autowired
	    private OrdersRepository ordersRepository;

	    public List<Orders> getOrderListByStatus(int status) {
	        return ordersRepository.findByStatus(status);
	    }

	    public long getOrderByStatus(String status) {
	        return ordersRepository.countByStatus(status);
	    }

	    public List<Orders> getOrderList() {
	        return ordersRepository.findAll();
	    }

	    public Optional<Orders> getOrderDetail(String id) {
	        return ordersRepository.findById(id);
	    }

	    public Orders updateOrder(String id, Orders orders) {
	        if (ordersRepository.existsById(id)) {
	            orders.setOrderId(id);
	            return ordersRepository.save(orders);
	        }
	        return null;
	    }

	    public Orders addOrder(Orders orders) {
	        return ordersRepository.save(orders);
	    }
}
