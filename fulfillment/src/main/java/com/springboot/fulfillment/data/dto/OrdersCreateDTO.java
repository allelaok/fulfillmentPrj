package com.springboot.fulfillment.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersCreateDTO {
	private String orderId;
	private String fkCustomerId;
	private String fkGoodsId;
	private Integer orderQuantity;
	private Integer orderStatus;
}
