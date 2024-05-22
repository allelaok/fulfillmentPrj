package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "purchase_id")
    private Long purchaseId;
    
    @Column(name = "purchase_quantity")
    private int quantity;
    
    @Column(name = "purchase_date")
//    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    
    @Column(name = "purchase_status")
    private int status;
    
    @ManyToOne
    @JoinColumn(name = "fk_goods_id")
    private Goods goods;
}
