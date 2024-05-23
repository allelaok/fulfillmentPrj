package com.springboot.fulfillment.data.dto;

import java.util.Date;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.entity.Storages;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class GoodsDTO {

	private Long no;
	private Long code;
	private String name;
	private Integer price;
    private String description;
    private String img1;
    private String img2;
    private Date regTime;
//	private Seller seller;
	private Integer stockQuantity;
	private Long sellerNo;
	private String storageName;
	

	public GoodsDTO fromGoods(Goods goods) {
		this.no = goods.getNo();
		this.code = goods.getCode();
		this.name = goods.getName();
		this.price = goods.getPrice();
		this.description = goods.getDescription();
		this.img1 = goods.getImg1();
		this.img2 = goods.getImg2();
		this.regTime = goods.getRegTime();
		
		Stock stock = goods.getStock();
		if(stock != null) {
			this.stockQuantity = stock.getQuantity();
			Storages storage = stock.getStorage();
			if(storage != null) {
				this.storageName = storage.getName();				
			}
		}
		
		this.sellerNo = goods.getSeller().getNo();
//		this.insertDateTime = goods.getInsertDateTime();
		return this;
	}
	
	public static GoodsDTO GoodsFactory(Goods goods) {
		GoodsDTO goodsDTO = new GoodsDTO();
		goodsDTO.fromGoods(goods);
		return goodsDTO;
	}
	
	public Goods fill(Goods goods, Stock stock, Seller seller) {
		goods.setName(this.name);
		goods.setCode(this.code);
		goods.setName(this.name);
		goods.setPrice(this.price);
		goods.setDescription(this.description);
		goods.setImg1(this.img1);
		goods.setImg2(this.img2);
		goods.setRegTime(this.regTime);
		if(stock != null)
		goods.setStock(stock);
		if(seller != null)
		goods.setSeller(seller);
		return goods;
	}
}
