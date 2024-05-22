package com.springboot.fulfillment.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCreateDTO {
	
	private String dDeliveryId;
	
	private Integer orderId;
	
	private Integer quantity;
	
	private Integer status;

}
