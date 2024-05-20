package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, String>{

}
