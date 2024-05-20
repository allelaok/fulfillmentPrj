package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	 
    @Id
    @Column(name = "order_id")
    private String orderId;
    
    @Column(name = "fk_customer_id")
    private String customerId;
    
//    @ManyToOne
//    @JoinColumn(name = "fk_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
//    private Customer customer;
    
    @Column(name = "fk_goods_id")
    private String goodsId;
    
    @ManyToOne
    @JoinColumn(name = "fk_goods_id", referencedColumnName = "goods_id", insertable = false, updatable = false)
    private Goods goods;
    
    @Column(name = "order_quantity", nullable = false)
    private int quantity;
    
    @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
    @Column(name = "order_status", nullable = false)
    private int status;
    
    @Column(name = "order_price", nullable = false)
    private double price;
    
    public Order() {
    }
    
    public Order(String orderId, String customerId, String goodsId, int quantity, Date orderDate, int status, double price) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
        this.price = price;
    }

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
}
