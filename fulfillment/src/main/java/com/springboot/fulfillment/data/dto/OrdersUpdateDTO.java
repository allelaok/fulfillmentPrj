package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersUpdateDTO {
	private Long id;
	private Integer status;
	

	public Orders fill(Orders orders) {
		orders.setId(this.id);
		orders.setStatus(this.status);
		return orders;
	}
	

}
