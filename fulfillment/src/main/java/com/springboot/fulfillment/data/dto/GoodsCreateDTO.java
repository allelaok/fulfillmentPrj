package com.springboot.fulfillment.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsCreateDTO {
	
	private String goodsId;
	
	private String goodsName;

	private Integer goodsPrice;
	
	private String sellerId;
	
}
