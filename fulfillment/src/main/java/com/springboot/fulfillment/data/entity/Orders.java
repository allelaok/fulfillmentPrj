package com.springboot.fulfillment.data.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Orders {
	 
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "order_id")
    private String orders;
    
//    @ManyToOne
//    @JoinColumn(name = "fk_customer_id", columnDefinition = "VARCHAR2", referencedColumnName = "customer_id", insertable = false, updatable = false)
//    private Customer customer;
    
    
    @ManyToOne
    @JoinColumn(name = "fk_goods_id")
    private Goods goods;
    
    @Column(name = "order_quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
    @Column(name = "order_status", nullable = false)
    private Integer status;
    
    @Column(name = "order_price", nullable = false)
    private double price;
    
}
