package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "stock")
public class Stock {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "stock_no")
   private Long no;
   
   @Column(nullable = false, name = "w_stock_no")
   private Long wStockNo;
   
   @ColumnDefault("0")
   @Column(name = "stock_quantity")
   private Integer quantity;
   
   @Column(nullable = false, name = "stock_regdate")
   private Date regdate;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_seller_no")
    private Seller seller;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_storage_no")
    private Storages storage;


	
}
