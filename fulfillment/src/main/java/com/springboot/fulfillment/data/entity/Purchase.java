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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_no")
    private Long no;
    
    @Column(name = "purchase_id")
    private String purchaseId;

    @Column(name = "purchase_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "purchase_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date purchaseDate;

    @Column(name = "purchase_status", nullable = false)
    private Integer purchaseStatus;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_goods_id")
    private Goods goods;
}
