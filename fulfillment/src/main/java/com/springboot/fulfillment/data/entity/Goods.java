package com.springboot.fulfillment.data.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goods")
public class Goods {

    @Id
    @Column(name = "goods_id")
    private String goodsId;
    
    @Column(name = "goods_name", nullable = false)
    private String goodsName;
    
//    @Column(name = "goods_price", nullable = false)
    @Column(name = "goods_price")
    private Integer goodsPrice;
    
    @Column(name = "goods_description")
    @Lob
    private String goodsDescription;
    
//    @Column(name = "goods_stock", nullable = false)
    @Column(name = "goods_stock")
    private int goodsStock;
    
//    @Column(name = "goods_img1", nullable = false)
    @Column(name = "goods_img1")
    private String goodsImg1;
    
    @Column(name = "goods_img2")
    private String goodsImg2;
    
//    @Column(name = "goods_regtime", nullable = false)
    @Column(name = "goods_regtime")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date goodsRegTime;
    
    @Column(name = "fk_seller_id")
    private String sellerId;
    
    @ManyToOne
    @JoinColumn(name = "fk_seller_id", referencedColumnName = "seller_id", insertable = false, updatable = false)
    private Seller seller;
	
    
}
