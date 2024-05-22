package com.springboot.fulfillment.data.entity;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private Long id;
    

    @Column(name = "goods_code")
    private Integer code;
    
    @Column(name = "goods_name", nullable = false)
    private String name;
    
    @Column(name = "goods_price")
    private Integer price;
    
    @Column(name = "goods_description")
    @Lob
    private String description;
    
//    @Column(name = "goods_stock", nullable = false)
//    @Column(name = "goods_stock")
//    private int goodsStock;
    
    @Column(name = "goods_img1")
    private String img1;
    
    @Column(name = "goods_img2")
    private String img2;
    
    @Column(name = "goods_regtime")

//    @Temporal(TemporalType.TIMESTAMP)
    private Date regTime;
    
    @ManyToOne
    @JoinColumn(name = "fk_seller_id")
    private Seller seller;
	
    
}
