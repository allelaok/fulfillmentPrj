package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Goods;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GoodsReadResponseDTO {

	private Integer goodsId;
	private String goodsName;
	private Integer goodsPrice;
	
	public GoodsReadResponseDTO fromGoods(Goods goods) {
		this.goodsId = goods.getGoodsId();
		this.goodsName = goods.getGoodsName();
		this.goodsPrice = goods.getGoodsPrice();
//		this.insertDateTime = goods.getInsertDateTime();
		return this;
	}
	
	public static GoodsReadResponseDTO GoodsFactory(Goods goods) {
		GoodsReadResponseDTO goodsReadResponseDTO = new GoodsReadResponseDTO();
		goodsReadResponseDTO.fromGoods(goods);
		return goodsReadResponseDTO;
	}
	
}
