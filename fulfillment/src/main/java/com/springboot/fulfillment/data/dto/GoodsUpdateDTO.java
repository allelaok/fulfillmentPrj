package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsUpdateDTO {

	private String goodsId;
	
	private String goodsName;

	private Integer goodsPrice;
	
	public Goods fill(Goods goods) {
		goods.setGoodsName(this.goodsName);
		goods.setGoodsPrice(this.goodsPrice);
		return goods;
	}
	
}
