package com.springboot.fulfillment.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Purchase;
import org.springframework.stereotype.Repository;

@Repository("purchaseRepository")
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	Purchase findByNo(Goods goodsId);
	Optional<Purchase> findByPurchaseId(String purchaseId);

	List<Purchase> findByGoodsStockNo(Long stockId);
}
