package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PurchaseReadResponseDTO {

	private String goodsId;
	private int quantity;
	private int status;
	
	public PurchaseReadResponseDTO fromPurchase(Purchase purchase) {
		this.goodsId = purchase.getGoodsId();
		this.quantity = purchase.getQuantity();
		this.status = purchase.getStatus();
//		this.insertDateTime = goods.getInsertDateTime();
		return this;
	}
	

	public static PurchaseReadResponseDTO PurchaseFactory(Purchase purchase) {
		PurchaseReadResponseDTO purchaseReadResponseDTO = new PurchaseReadResponseDTO();
		purchaseReadResponseDTO.fromPurchase(purchase);
		return purchaseReadResponseDTO;
	}
	
	
}
