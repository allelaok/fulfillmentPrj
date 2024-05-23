package com.springboot.fulfillment.data.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(nullable = false, name = "w_stock_id")
    private Long wStockId;

    @ColumnDefault("0")
    @Column(name = "stock_quantity")
    private Integer quantity;

    @Column(name = "stock_regdate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_seller_no")
    private Seller seller;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_storage_no")
    private Storages storage;

	
}
