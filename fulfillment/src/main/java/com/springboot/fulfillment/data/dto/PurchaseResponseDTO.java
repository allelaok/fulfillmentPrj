package com.springboot.fulfillment.data.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//판매자가 발주신청시 제조사에게 발주(order)요청을 보내는 DTO

@NoArgsConstructor
@Getter
@Setter
public class PurchaseResponseDTO {

	private Long fkProductId;
	private Integer orderQuantity;
	private Date orderDate;//생략가능
	private Integer orderStatus;//생략가능
}
