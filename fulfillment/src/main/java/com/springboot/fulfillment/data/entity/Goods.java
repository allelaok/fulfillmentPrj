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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_no")
    private Long no;
    

    @Column(name = "goods_code", unique = true, nullable = false)
    private Integer code;
    
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
    
    @Column(name = "goods_regtime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regTime;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_seller_id")
    private Seller seller;
   
}
