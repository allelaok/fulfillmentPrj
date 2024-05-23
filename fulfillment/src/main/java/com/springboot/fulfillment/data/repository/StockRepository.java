package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

//	List<Stock> findByStatusAndRegdate(int status, Date regdate);
//	long countByStatusAndRegdate(int status, Date regdate);
	
}
