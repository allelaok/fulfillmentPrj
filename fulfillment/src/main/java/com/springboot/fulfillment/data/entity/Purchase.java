package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private String purchaseId;
    
    @Column(name = "fk_goods_id")
    private String goodsId;
    
    @Column(name = "purchase_quantity")
    private int quantity;
    
    @Column(name = "purchase_date")
//    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    
    @Column(name = "purchase_status")
    private int status;
    
    @ManyToOne
    @JoinColumn(name = "fk_goods_id", referencedColumnName = "goods_id", insertable = false, updatable = false)
    private Goods goods;
}
