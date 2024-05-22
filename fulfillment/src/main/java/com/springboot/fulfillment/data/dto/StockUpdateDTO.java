package com.springboot.fulfillment.data.dto;

import java.sql.Date;

import com.springboot.fulfillment.data.entity.Stock;

public class StockUpdateDTO {

	private Long no;
	private Long wStockNo;
   private Integer quantity;
   private Date regdate;
    
   public Stock fill(Stock stock) {
      stock.setNo(this.no);
      stock.setWStockNo(this.wStockNo);
      stock.setQuantity(this.quantity);
      stock.setRegdate(this.regdate);
      return stock;
   }

}
