package com.springboot.fulfillment.data.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO {

	 private Long wStockNo;
	   
	 private Integer quantity;
   
	 private Date regdate;
   
	 private String sellerNo;
    
	 private Long storageNo;
}
