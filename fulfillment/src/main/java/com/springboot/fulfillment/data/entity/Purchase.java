package com.springboot.fulfillment.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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

    @Column(name = "purchase_date", nullable = false, columnDefinition = "DATE DEFAULT SYSDATE")
    private Date purchaseDate;

    @Column(name = "purchase_status", nullable = false)
    private Integer purchaseStatus;
    
    @ManyToOne
    @JoinColumn(name = "fk_goods_id")
    private Goods goods;
}
