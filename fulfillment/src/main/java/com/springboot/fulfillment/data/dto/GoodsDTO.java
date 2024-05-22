package com.springboot.fulfillment.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GoodsDTO {

	private Integer goodsId;
	private String goodsName;
	private Integer goodsPrice;
}
