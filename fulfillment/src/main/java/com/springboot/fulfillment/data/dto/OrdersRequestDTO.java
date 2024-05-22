package com.springboot.fulfillment.data.dto;

import java.util.Date;

import com.springboot.fulfillment.data.entity.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrdersRequestDTO {

	private String customerName;
	private String customerContact;
	private Long customerZipCode;
	private String customerStreetAddress;
	private String customerDetailAddress;

	private Long goodsCode;

	private int orderStock;
	private Date orderDate;
	private int orderStatus;
	private Long orderPrice;

}
