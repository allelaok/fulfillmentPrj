package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Delivery;
import org.springframework.stereotype.Repository;

@Repository("deliveryRepository")
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
