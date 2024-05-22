package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.DeliveryCreateDTO;
import com.springboot.fulfillment.data.dto.DeliveryListResponseDTO;
import com.springboot.fulfillment.data.dto.DeliveryReadResponseDTO;
import com.springboot.fulfillment.data.dto.DeliveryUpdateDTO;
import com.springboot.fulfillment.data.dto.OrdersUpdateDTO;
import com.springboot.fulfillment.data.entity.Delivery;
import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.DeliveryRepository;
import com.springboot.fulfillment.data.repository.OrdersRepository;

@Service
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;

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
	
	public DeliveryReadResponseDTO getDeliveryDetail(Integer id) throws NoSuchElementException {
        Delivery delivery = this.deliveryRepository.findById(id).orElseThrow();
        DeliveryReadResponseDTO deliveryReadResponseDTO = new DeliveryReadResponseDTO();
        deliveryReadResponseDTO.fromDelivery(delivery);
        return deliveryReadResponseDTO;
    }
	
	public void addDelivery(DeliveryCreateDTO deliveryCreateDTO) {
		Orders orders = ordersRepository.findById(deliveryCreateDTO.getOrderId()).orElseThrow();
		
		Delivery delivery = Delivery.builder()
				.dDeliveryId(deliveryCreateDTO.getDDeliveryId())
				.quantity(deliveryCreateDTO.getQuantity())
				.status(deliveryCreateDTO.getStatus())
				.order(orders)
				.build();
//		delivery.setOrderId(orders.getOrders());
        this.deliveryRepository.save(delivery);
    }
	
	public void updateDelivery(DeliveryUpdateDTO deliveryUpdateDTO) throws NoSuchElementException {
		Delivery delivery = this.deliveryRepository.findById(deliveryUpdateDTO.getId()).orElseThrow();
		delivery = deliveryUpdateDTO.fill(delivery);
		this.deliveryRepository.save(delivery);
	}
}
