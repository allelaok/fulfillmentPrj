package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.OrderListResponseDTO;
import com.springboot.fulfillment.data.dto.OrdersCreateDTO;
import com.springboot.fulfillment.data.dto.OrdersReadResponseDTO;
import com.springboot.fulfillment.data.dto.OrdersUpdateDTO;
import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.OrdersRepository;

@Service
public class OrdersService {
	 @Autowired
	    private OrdersRepository ordersRepository;
	    
	    public List<OrderListResponseDTO> getOrderListByStatus(String goodsId, int status) {
	        List<Orders> ordersList = ordersRepository.findByGoodsIdAndStatus(goodsId, status);
	        List<OrderListResponseDTO> ordersDTOList = new ArrayList<>();
	        for (Orders orders : ordersList) {
	            OrderListResponseDTO ordersDTO = new OrderListResponseDTO();
	            ordersDTO.fromOrders(orders);
	            ordersDTOList.add(ordersDTO);
	        }
	        return ordersDTOList;
	    }
	    
	    
	    public List<OrderListResponseDTO> getOrderList(String goodsId) {
	        List<Orders> ordersList = ordersRepository.findByGoodsId(goodsId);
	        List<OrderListResponseDTO> ordersDTOList = new ArrayList<>();
	        for (Orders orders : ordersList) {
	            OrderListResponseDTO ordersDTO = new OrderListResponseDTO();
	            ordersDTO.fromOrders(orders);
	            ordersDTOList.add(ordersDTO);
	        }
	        return ordersDTOList;
	    }
	    

	    public long getCountByStatus(String ordersId, int status) {
	        return ordersRepository.countByGoodsIdAndStatus(ordersId, status);
	    }

	
	    public OrdersReadResponseDTO getOrder(String goodsId) throws NoSuchElementException{
	    	Orders orders = this.ordersRepository.findById(goodsId).orElseThrow();
	    	OrdersReadResponseDTO ordersReadResponseDTO = new OrdersReadResponseDTO();
			ordersReadResponseDTO.fromOrders(orders);
			return ordersReadResponseDTO;
	    }


	    public void updateOrder(OrdersUpdateDTO ordersUpdateDTO) throws NoSuchElementException{
	    	Orders orders = this.ordersRepository.findById(ordersUpdateDTO.getOrderId()).orElseThrow();
	    	orders = ordersUpdateDTO.fill(orders);
			this.ordersRepository.save(orders);
	    }

	    public void addOrder(OrdersCreateDTO ordersCreateDTO) {
	    	
	    	Orders orders = Orders.builder()
					.orderId(ordersCreateDTO.getOrderId())
					.customerId(ordersCreateDTO.getFkCustomerId())
					.goodsId(ordersCreateDTO.getFkGoodsId())
					.quantity(ordersCreateDTO.getOrderQuantity())
					.status(ordersCreateDTO.getOrderStatus())
					.build();
	    	
	        this.ordersRepository.save(orders);
	    }
}
