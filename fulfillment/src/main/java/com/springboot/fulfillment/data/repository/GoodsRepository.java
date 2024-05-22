package com.springboot.fulfillment.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;

public interface GoodsRepository extends JpaRepository<Goods, Long>{
	List<Goods> findBySellerId(Seller sellerId);
}
