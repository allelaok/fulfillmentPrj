package com.springboot.fulfillment.data.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//발주요청한 후에 발주완료가 되었을때, status업데이트 요청을 받는 DTO

@NoArgsConstructor
@Getter
@Setter
public class PurchaseRequestDTO {

	private Long order_id;
	private Long fk_product_id;
	private Integer order_quantity;
	private Date order_date;
	private Integer order_status;
	
}
