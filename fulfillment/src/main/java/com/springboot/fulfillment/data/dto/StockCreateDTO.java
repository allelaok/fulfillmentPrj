package com.springboot.fulfillment.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockCreateDTO {

	private String stockId;
	private Integer stockQuantity;
	private Integer stockStatus;
	private Integer stockQuality;
	private String fkSellerId;
	private Integer fkStorageId;
	private Integer fkOrderId;
}
