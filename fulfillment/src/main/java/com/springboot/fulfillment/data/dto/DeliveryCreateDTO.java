package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCreateDTO {
	
	private String dDeliveryId;
	
	private Long orderId;
	
	private Integer quantity;
	
	private Integer status;

}
