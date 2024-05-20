package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, String>{

}
