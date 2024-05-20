package com.springboot.fulfillment.data.entity;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    private String purchaseId;
    
    @Column(name = "fk_goods_id")
    private String goodsId;
    
    @Column(name = "purchase_quantity")
    private int quantity;
    
    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    
    @Column(name = "purchase_status")
    private int status;
    
    @ManyToOne
    @JoinColumn(name = "fk_goods_id", referencedColumnName = "goods_id", insertable = false, updatable = false)
    private Goods goods;
    

    public Purchase() {
    }
    
    public Purchase(String purchaseId, String goodsId, int quantity, Date purchaseDate, int status) {
        this.purchaseId = purchaseId;
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }
    
    // Getters and Setters
    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
