package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Goods;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GoodsListResponseDTO {

	private String goodsId;
	private String goodsName;
	private Integer goodsPrice;
	
	public GoodsListResponseDTO fromGoods(Goods goods) {
		this.goodsId = goods.getGoodsId();
		this.goodsName = goods.getGoodsName();
		this.goodsPrice = goods.getGoodsPrice();
//		this.insertDateTime = goods.getInsertDateTime();
		return this;
	}
	
	public static GoodsListResponseDTO GoodsFactory(Goods goods) {
		GoodsListResponseDTO goodsListResponseDTO = new GoodsListResponseDTO();
		goodsListResponseDTO.fromGoods(goods);
		return goodsListResponseDTO;
	}
	
}
