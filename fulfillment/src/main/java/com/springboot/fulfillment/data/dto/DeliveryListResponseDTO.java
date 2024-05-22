package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Delivery;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeliveryListResponseDTO {

	private String dDeliveryId;
	private Integer quantity;
	private Integer status;
	
	public DeliveryListResponseDTO fromDelivery(Delivery delivery) {
		this.dDeliveryId = delivery.getDDeliveryId();
		this.quantity = delivery.getQuantity();
		this.status = delivery.getStatus();
		return this;
	}
	
	public static DeliveryListResponseDTO DeliveryFactory(Delivery delivery) {
		DeliveryListResponseDTO deliveryListResponseDTO = new DeliveryListResponseDTO();
		deliveryListResponseDTO.fromDelivery(delivery);
		return deliveryListResponseDTO;
	}
}
