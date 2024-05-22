package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dao.OrderDAO;
import com.springboot.fulfillment.data.dto.OrdersRequestDTO;
import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.CustomerRepository;
import com.springboot.fulfillment.data.repository.GoodsRepository;

@Service("OrderService")
public class OrdersService {

	@Autowired
	private OrderDAO orderDAO;
	
	private final GoodsRepository goodsRepository = null;
	private final CustomerRepository customerRepository = null;

	// 리스트자료형 entity => dto로 변경
//	public List<Orders> getOrderList(String id) throws Exception {
//
//		List<Long> goodsIdList = orderDAO.findGoodsIdBySellerID(id);
//		List<Orders> ordersList = new ArrayList<>();
//		for (Long goodsId : goodsIdList) {
//			ordersList.add(orderDAO.findById(goodsId));
//		}
//		return ordersList;
//	}

//	public void addOrder(OrdersRequestDTO ordersRequestDTO) {
//
//		//customer
//		Customer customer = null;
//		customer.setName(ordersRequestDTO.getCustomerName());
//		customer.setContact(ordersRequestDTO.getCustomerContact());
//		customer.setZipCode(ordersRequestDTO.getCustomerZipCode());
//		customer.setStreetAddress(ordersRequestDTO.getCustomerStreetAddress());
//		customer.setDetailAddress(ordersRequestDTO.getCustomerDetailAddress());
//		
//		Customer result =  customerRepository.save(customer);
//		
//		//goods		
//		Optional<Goods> goods = goodsRepository.findByGoodsCode(ordersRequestDTO.getGoodsCode());
//
//		Orders order = Orders.builder()
////				.customer(result)
//				.goods(goods.get())
//				.quantity(ordersRequestDTO.getOrderStock())
//				.orderDate(ordersRequestDTO.getOrderDate())
//				.status(ordersRequestDTO.getOrderStatus())
//				.price(ordersRequestDTO.getOrderPrice())
//				.build();
//
//		orderDAO.save(order);
//	}

	public void changeOrderStatus(Long id) throws Exception{
		
		Orders order = orderDAO.findById(id);
		
		order.setStatus(1);//상황따라서 변경해주는 조건문추가
		
		orderDAO.save(order);
	}
		
}
