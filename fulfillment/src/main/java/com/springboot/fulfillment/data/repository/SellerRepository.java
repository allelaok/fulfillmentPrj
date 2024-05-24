package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Seller;
import org.springframework.stereotype.Repository;

@Repository("sellerRepository")
public interface SellerRepository extends JpaRepository<Seller, Long> {
Seller findBySellerIdContains(String sellerId);

Seller findByContactContains(String contact);

}
