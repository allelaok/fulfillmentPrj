package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Delivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryUpdateDTO {

	private Integer id;
	
	private String dDeliveryId;
	
	private Integer quantity;

	private Integer status;
	
	public Delivery fill(Delivery delivery) {
		delivery.setQuantity(this.quantity);
		delivery.setStatus(this.status);
		return delivery;
	}
}
