package com.springboot.fulfillment.data.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerResponseDTO {

	private String id;
	private Long sellerId;
	private String sellerName;
	private String sellerContact;
	private String sellerCompany;

	private Long goodsId;
	private Long goodsCode;
	private String goodsName;
	private int goodsPrice;
	private String goodsDescription;
	private int goodsStock;
	private String goodsImg1;
	private String goodsImg2;
	private Date goodsRegDate;
}
