package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Delivery;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeliveryReadResponseDTO {

	private String dDeliveryId;
	private Integer quantity;
	private Integer status;
	
	public DeliveryReadResponseDTO fromDelivery(Delivery delivery) {
		this.dDeliveryId = delivery.getDDeliveryId();
		this.quantity = delivery.getQuantity();
		this.status = delivery.getStatus();
		return this;
	}
	
	public static DeliveryReadResponseDTO DeliveryFactory(Delivery delivery) {
		DeliveryReadResponseDTO deliveryReadResponseDTO = new DeliveryReadResponseDTO();
		deliveryReadResponseDTO.fromDelivery(delivery);
		return deliveryReadResponseDTO;
	}
}
