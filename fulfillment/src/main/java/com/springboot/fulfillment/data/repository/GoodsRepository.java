package com.springboot.fulfillment.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>{
	List<Goods> findBySeller(Seller seller);
	List<Goods> findAllBySeller(Seller seller);
//	
//	//이하 문승환 작업중
	List<Long> findGoodsIdBySeller(Seller seller);
	Optional<Goods> findByCode(Integer goodsCode);
	
	
}
