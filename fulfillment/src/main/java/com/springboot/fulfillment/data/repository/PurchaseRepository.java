package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Purchase;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	Purchase findByNo(Goods goodsId);


	List<Purchase> findByGoodsStockNo(Long stockNo);
}
