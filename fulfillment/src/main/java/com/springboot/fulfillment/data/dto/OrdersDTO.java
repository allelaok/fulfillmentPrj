package com.springboot.fulfillment.data.dto;

import java.util.Date;

import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrdersDTO {

	private String orderId;
	private int quantity;
	private Date orderDate;
	private int status;
	private double price;
	
	
	
	

	// 필요에 따라 메소드 추가
	public Orders fill(Orders orders) {
		orders.setOrderId(orderId);
		orders.setQuantity(quantity);
		orders.setStatus(status);
		orders.setPrice(price);
		return orders;
	}

}
