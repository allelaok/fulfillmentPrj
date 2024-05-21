package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dao.OrderDAO;
import com.springboot.fulfillment.data.dto.OrderListResponseDTO;
import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrderDAO orderDAO;

	// 리스트자료형 entity => dto로 변경
	public List<Orders> getOrderList(String id) throws Exception {

		List<String> goodsIdList = orderDAO.findGoodsIdBySellerID(id);
		List<Orders> ordersList = new ArrayList<>();
		for (String goodsId : goodsIdList) {
			ordersList.add(orderDAO.findById(goodsId));
		}
		return ordersList;
	}

	// entity => dto로 변경
	public void addOrder(Orders order) {

		Orders orderdto = Orders.builder()
				.orderId(order.getOrderId())
				.customer(order.getCustomer())
				.goods(order.getGoods())
				.quantity(order.getQuantity())
				.status(order.getStatus())
				.build();

		this.orderDAO.save(orderdto);
	}
	
//	entity => dto로 변경
	public void changeOrderStatus(String id) throws Exception{
		
		Orders order = orderDAO.findById(id);
		
		order.setStatus(1);//상황따라서 변경해주는 조건문추가
		
		orderDAO.save(order);
	}
	
//	// entity => dto로 변경
//	public void updateOrder(Orders order){
//		Orders orders = this.ordersRepository.findById(ordersUpdateDTO.getOrderId()).orElseThrow();
//		orders = ordersUpdateDTO.fill(orders);
//		this.ordersRepository.save(orders);
//	}
	
}
