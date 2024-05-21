package com.springboot.fulfillment.data.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.GoodsRepository;
import com.springboot.fulfillment.data.repository.OrdersRepository;

@Repository
public class OrderDAO {

	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;

	public List<String> findGoodsIdBySellerID(String id) {

		List<String> goodsIdList = goodsRepository.findGoodsIdBySellerId(id);

		return goodsIdList;
	}

	public Orders findById(String id) throws Exception {

		Optional<Orders> orders = ordersRepository.findById(id);

		if (orders.isPresent()) {
			return orders.get();
		} else {
			throw new Exception();
		}

	}
	
	//entity => dto로 변경
	public void save(Orders order) {
		ordersRepository.save(order);
	}
	
}
