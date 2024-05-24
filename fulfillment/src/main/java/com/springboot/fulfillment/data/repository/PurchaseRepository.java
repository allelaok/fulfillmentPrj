package com.springboot.fulfillment.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	Purchase findByNo(Goods goodsId);
	Optional<Purchase> findByPurchaseId(String purchaseId);
}
