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

	private Long goodsNo;
	private Long goodsCode;
	private String goodsName;
	private Integer goodsPrice;
    private String goodsDescription;
    private String goodsImg1;
    private String goodsImg2;
    private Date regTime;
//	private Seller seller;
	private Integer goodsStock;
	private Long sellerNo;
	private String storageName;

    Long stockNo;

    String sellerId;
    
    
    
	public GoodsDTO fromGoods(Goods goods) {
		this.goodsNo = goods.getNo();
		this.goodsCode = goods.getCode();
		this.goodsName = goods.getName();
		this.goodsPrice = goods.getPrice();
		this.goodsDescription = goods.getDescription();
		this.goodsImg1 = goods.getImg1();
		this.goodsImg2 = goods.getImg2();
		this.regTime = goods.getRegTime();
		
		Stock stock = goods.getStock();
		if(stock != null) {
			this.goodsStock = stock.getQuantity();
			Storages storage = stock.getStorage();
			this.stockNo = stock.getNo();
			if(storage != null) {
				this.storageName = storage.getName();				
			}
		}
		
		Seller seller = goods.getSeller();
		if(seller != null) {
			this.sellerNo = seller.getNo();
			this.sellerId = seller.getSellerId();			
		}
	    
//		this.insertDateTime = goods.getInsertDateTime();
		return this;
	}
	
	public static GoodsDTO GoodsFactory(Goods goods) {
		GoodsDTO goodsDTO = new GoodsDTO();
		goodsDTO.fromGoods(goods);
		return goodsDTO;
	}
	
	public Goods fill(Goods goods, Stock stock, Seller seller) {
		goods.setName(this.goodsName);
		goods.setCode(this.goodsCode);
		goods.setName(this.goodsName);
		goods.setPrice(this.goodsPrice);
		goods.setDescription(this.goodsDescription);
		goods.setImg1(this.goodsImg1);
		goods.setImg2(this.goodsImg2);
		goods.setRegTime(this.regTime);
		if(stock != null)
		goods.setStock(stock);
		if(seller != null)
		goods.setSeller(seller);
		return goods;
	}
	
}
