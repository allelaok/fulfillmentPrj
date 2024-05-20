package com.springboot.fulfillment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.fulfillment.data.entity.Delivery;
import com.springboot.fulfillment.data.repository.DeliveryRepository;

public class DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	public List<Delivery> getDeliveryList() {
        return deliveryRepository.findAll();
    }
	
	public Optional<Delivery> getDeliveryDetail(String id) {
        return deliveryRepository.findById(id);
    }
	
	public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }
	
	public void updateDelivery(Delivery delivery) {
        
		deliveryRepository.save(delivery);
    }
}
