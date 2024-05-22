package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.DeliveryListResponseDTO;
import com.springboot.fulfillment.data.entity.Delivery;
import com.springboot.fulfillment.data.repository.DeliveryRepository;

@Service
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	public List<DeliveryListResponseDTO> getDeliveryList() {
		List<Delivery> deliveryList = deliveryRepository.findAll();
		List<DeliveryListResponseDTO> deliveryDTOList = new ArrayList<>();
       for (Delivery delivery : deliveryList) {
    	   DeliveryListResponseDTO deliveryDTO = new DeliveryListResponseDTO();
           deliveryDTO.fromDelivery(delivery);
           deliveryDTOList.add(deliveryDTO);
       }
       return deliveryDTOList;
   }
	
	public Optional<Delivery> getDeliveryDetail(Integer id) {
        return deliveryRepository.findById(id);
    }
	
	public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }
	
	public Delivery updateDelivery(Integer id, Delivery delivery) {
		if (deliveryRepository.existsById(id)) {
			delivery.setId(id);
			return deliveryRepository.save(delivery);
		}
		return null;
	}
}
