package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @Column(name = "goods_id")
    private String goodsId;
    
    @Column(name = "goods_name", nullable = false)
    private String goodsName;
    
    @Column(name = "goods_price", nullable = false)
    private double goodsPrice;
    
    @Column(name = "goods_description")
    @Lob
    private String goodsDescription;
    
    @Column(name = "goods_stock", nullable = false)
    private int goodsStock;
    
    @Column(name = "goods_img1", nullable = false)
    private String goodsImg1;
    
    @Column(name = "goods_img2")
    private String goodsImg2;
    
    @Column(name = "goods_regtime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date goodsRegTime;
    
    @Column(name = "fk_seller_id")
    private String sellerId;
    
//    @ManyToOne
//    @JoinColumn(name = "fk_seller_id", referencedColumnName = "seller_id", insertable = false, updatable = false)
//    private Seller seller;

    public Goods() {
    }
    
    public Goods(String goodsId, String goodsName, double goodsPrice, String goodsDescription, int goodsStock,
                 String goodsImg1, String goodsImg2, Date goodsRegTime, String sellerId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDescription = goodsDescription;
        this.goodsStock = goodsStock;
        this.goodsImg1 = goodsImg1;
        this.goodsImg2 = goodsImg2;
        this.goodsRegTime = goodsRegTime;
        this.sellerId = sellerId;
    }

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public int getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}

	public String getGoodsImg1() {
		return goodsImg1;
	}

	public void setGoodsImg1(String goodsImg1) {
		this.goodsImg1 = goodsImg1;
	}

	public String getGoodsImg2() {
		return goodsImg2;
	}

	public void setGoodsImg2(String goodsImg2) {
		this.goodsImg2 = goodsImg2;
	}

	public Date getGoodsRegTime() {
		return goodsRegTime;
	}

	public void setGoodsRegTime(Date goodsRegTime) {
		this.goodsRegTime = goodsRegTime;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
    
    
}
