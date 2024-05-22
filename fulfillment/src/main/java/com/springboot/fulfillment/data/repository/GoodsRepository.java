package com.springboot.fulfillment.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.fulfillment.data.entity.Goods;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, String>{
	List<Goods> findBySellerId(String sellerId);
//	List<Goods> findAllBySellerSeller(String sellerId);
	List<Goods> findAllBySeller(String sellerId);
	
	//이하 문승환 작업중
	List<String> findGoodsIdBySellerId(String sellerId);
	Optional<Goods> findByGoodsCode(Long goodsCode);
	
	
}
