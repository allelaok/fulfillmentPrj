package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
Seller findBySellerIdContains(String sellerId);

Seller findByContactContains(String contact);

}
