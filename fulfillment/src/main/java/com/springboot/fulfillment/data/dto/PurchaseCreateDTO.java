package com.springboot.fulfillment.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseCreateDTO {

	private String purchaseId;
	private String goodsId;
	private int quantity;
	private int status;
}
