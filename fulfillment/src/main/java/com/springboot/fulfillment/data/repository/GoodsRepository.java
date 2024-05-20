package com.springboot.fulfillment.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, String>{
	List<Goods> findBySellerId(String sellerId);
}
