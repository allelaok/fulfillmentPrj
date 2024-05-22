package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Stock;

public class StockUpdateDTO {

	private String id;
	private Integer quantity;
	private Integer status;
	private Integer quality;
	private String fkSellerId;
	private Integer fkStorageId;
	private Integer fkOrderId;
	
	public Stock fill(Stock stock) {
//		stock.setId(this.id);
		stock.setQuantity(this.quantity);
		stock.setStatus(this.status);
		stock.setQuality(this.quality);
		return stock;
	}
}
