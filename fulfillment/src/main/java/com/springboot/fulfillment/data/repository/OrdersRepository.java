package com.springboot.fulfillment.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.fulfillment.data.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	List<Orders> findAllByStatus(Integer status);
	Optional<Orders> findById(Long no);


}
