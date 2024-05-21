package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Seller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsCreateDTO {
	
	private Integer goodsId;

	private Integer goodsCode;
	
	private String goodsName;

	private Integer goodsPrice;
	
	private String sellerId;
	
	private Seller seller;
	
}
