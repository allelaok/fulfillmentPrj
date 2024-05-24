package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.entity.Storages;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StockResponseDTO {

	 private Long wStockNo;
	   
	 private Integer quantity;
   
	 private Date regdate;
   
	 private Long sellerNo;
    
	 private Long storageNo;
	 

		public StockResponseDTO fromStock(Stock stock) {
			this.wStockNo = stock.getWStockId();
			this.quantity = stock.getQuantity();
			this.regdate = stock.getRegDate();
			
			Seller seller = stock.getSeller();
			if(seller != null)
			this.sellerNo = seller.getNo();
			Storages storage = stock.getStorage();
			if(storage != null)
			this.storageNo = storage.getNo();
			return this;
		}
		

}
