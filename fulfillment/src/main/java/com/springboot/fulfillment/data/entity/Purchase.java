package com.springboot.fulfillment.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_no")
    private Long no;
    
    @Column(name = "p_order_id")
    private String purchaseId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_goods_no")
    private Goods goods;

    @Column(name = "purchase_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "purchase_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;

    @Column(name = "purchase_status", nullable = false)
    private Integer purchaseStatus;
    
}
