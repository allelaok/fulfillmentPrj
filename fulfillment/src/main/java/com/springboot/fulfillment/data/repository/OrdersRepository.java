package com.springboot.fulfillment.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

	List<Orders> findAllByGoodsAndStatus(Goods goodsNo, Integer status);
	Integer findCountByGoodsAndStatusAndUpdateDate(Goods Goods, Integer status, Date update_date);
	List<Orders> findAllByGoods(Goods goodsNo);
	Orders findByGoods(Goods goodsNo);
}
