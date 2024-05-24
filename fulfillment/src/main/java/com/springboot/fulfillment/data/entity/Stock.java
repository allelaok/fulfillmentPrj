package com.springboot.fulfillment.data.entity;

import java.util.Date;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
