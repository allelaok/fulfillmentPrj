package com.springboot.fulfillment.data.dto;

import java.util.Date;

import com.springboot.fulfillment.data.entity.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrdersResponseDTO {

	private Long fkProductId;
	private Long orderQuantity;
	private Date orderDate;
	private Long orderStatus;

}
