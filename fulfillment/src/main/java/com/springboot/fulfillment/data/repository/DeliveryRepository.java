package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
