package com.springboot.fulfillment.data.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_no")
    private Long no;
    

    @Column(name = "goods_code", unique = true, nullable = false)
    private Long code;
    
    @Column(name = "goods_name", nullable = false)
    private String name;
    
    @Column(name = "goods_price", nullable = false)
    private Integer price;
    
    @Column(name = "goods_description", columnDefinition = "TEXT")
    private String description;
   
    @Column(name = "goods_img1", nullable = false)
    private String img1;

    @Column(name = "goods_img2")
    private String img2;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "goods_regtime", nullable = false)
    private Date regTime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_seller_no")
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_stock_no")
    private Stock stock;
    
    @PrePersist
    protected void onCreate() {
        regTime = new Date();
    }

}
