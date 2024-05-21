package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Purchase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseUpdateDTO {

    private String purchaseId;
    private String goodsId;
    private int quantity;
    private int status;
    
	public Purchase fill(Purchase purchase) {
		purchase.setPurchaseId(this.purchaseId);
		purchase.setGoodsId(this.goodsId);
		purchase.setQuantity(this.quantity);
		purchase.setStatus(this.status);
		return purchase;
	}
}
