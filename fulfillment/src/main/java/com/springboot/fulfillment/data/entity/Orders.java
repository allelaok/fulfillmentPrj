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
@Table(name = "orders")
public class Orders {
	 
    @Id
    @Column(name = "order_id")
    private String orderId;
    
    @Column(name = "fk_customer_id")
    private String customerId;
    
    @ManyToOne
    @JoinColumn(name = "fk_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    private Customer customer;
    
    @Column(name = "fk_goods_id")
    private String goodsId;
    
    @ManyToOne
    @JoinColumn(name = "fk_goods_id", referencedColumnName = "goods_id", insertable = false, updatable = false)
    private Goods goods;
    
    @Column(name = "order_quantity", nullable = false)
    private int quantity;
    
    @Column(name = "order_date", nullable = false)
//    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
    @Column(name = "order_status", nullable = false)
    private int status;
    
    @Column(name = "order_price", nullable = false)
    private double price;
    
}
