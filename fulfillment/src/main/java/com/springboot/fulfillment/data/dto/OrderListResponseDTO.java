package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OrderListResponseDTO {

	private Long orderId;
	private Customer customerId;
    private Goods goodsId;
    private Integer quantity;
    private Integer status;
	
	public OrderListResponseDTO fromOrders(Orders orders) {
		this.orderId = orders.getId();
//		this.customerId = orders.getCustomer();
		this.goodsId = orders.getGoods();
		this.quantity = orders.getQuantity();
		this.status = orders.getStatus();
//		this.insertDateTime = orders.getInsertDateTime();
		return this;
	}
	
	public static OrderListResponseDTO OrdersFactory(Orders orders) {
		OrderListResponseDTO ordersListResponseDTO = new OrderListResponseDTO();
		ordersListResponseDTO.fromOrders(orders);
		return ordersListResponseDTO;
	}
}
