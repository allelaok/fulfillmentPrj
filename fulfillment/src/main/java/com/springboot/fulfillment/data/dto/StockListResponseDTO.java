package com.springboot.fulfillment.data.dto;

import java.sql.Date;

import com.springboot.fulfillment.data.entity.Stock;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StockListResponseDTO {

   private Long wStockNo;
   private Integer quantity;
   private Date regdate;
   
   public StockListResponseDTO fromStock(Stock stock) {
      this.wStockNo = stock.getWStockNo();
      this.quantity = stock.getQuantity();
      this.regdate = stock.getRegdate();
      return this;
   }
   
   public static StockListResponseDTO StockFactory(Stock stock) {
      StockListResponseDTO stockListResponseDTO = new StockListResponseDTO();
      stockListResponseDTO.fromStock(stock);
      return stockListResponseDTO;
   }

}
