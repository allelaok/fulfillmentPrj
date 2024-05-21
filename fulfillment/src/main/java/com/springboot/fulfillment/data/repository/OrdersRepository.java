package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.fulfillment.data.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String>{


}
