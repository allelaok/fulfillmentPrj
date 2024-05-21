package com.springboot.fulfillment.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, String>{
	
	List<Orders> findByGoodsIdAndStatus(String goodsId, int status); 
	
	List<Orders> findByGoodsId(String goodsId);
	
	 long countByGoodsIdAndStatus(String goodsId, int status); 
}
