package com.springboot.fulfillment.data.dto;

import java.sql.Date;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class GoodsDTO {

	private Long id;
	private Integer code;
	private String name;
	private Integer price;
    private String description;
    private String img1;
    private String img2;
    private Date regTime;
	private Seller seller;
	
	private String sellerId;
	

	public GoodsDTO fromGoods(Goods goods) {
//		this.id = goods.getId();
		this.code = goods.getCode();
		this.name = goods.getName();
		this.price = goods.getPrice();
		this.description = goods.getDescription();
		this.img1 = goods.getImg1();
		this.img2 = goods.getImg2();
//		this.regTime = goods.getRegTime();
		this.seller = goods.getSeller();
//		this.insertDateTime = goods.getInsertDateTime();
		return this;
	}
	
	public static GoodsDTO GoodsFactory(Goods goods) {
		GoodsDTO goodsDTO = new GoodsDTO();
		goodsDTO.fromGoods(goods);
		return goodsDTO;
	}
	
	public Goods fill(Goods goods) {
		goods.setName(this.name);
		goods.setPrice(this.code);
		goods.setName(this.name);
		goods.setPrice(this.price);
		goods.setDescription(this.description);
		goods.setImg1(this.img1);
		goods.setImg2(this.img2);
		goods.setRegTime(this.regTime);
		goods.setSeller(this.seller);
		return goods;
	}
}
