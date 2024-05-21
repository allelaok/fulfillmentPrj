package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OrdersReadResponseDTO {

	private String orderId;
	private String customerId;
    private String goodsId;
    private Integer quantity;
    private Integer status;

	public OrdersReadResponseDTO fromOrders(Orders orders) {
		this.orderId = orders.getOrderId();
		this.customerId = orders.getCustomerId();
		this.goodsId = orders.getGoodsId();
		this.quantity = orders.getQuantity();
		this.status = orders.getStatus();
//		this.insertDateTime = orders.getInsertDateTime();
		return this;
	}

	public static OrdersReadResponseDTO OrdersFactory(Orders orders) {
		OrdersReadResponseDTO ordersReadResponseDTO = new OrdersReadResponseDTO();
		ordersReadResponseDTO.fromOrders(orders);
		return ordersReadResponseDTO;
	}
}
