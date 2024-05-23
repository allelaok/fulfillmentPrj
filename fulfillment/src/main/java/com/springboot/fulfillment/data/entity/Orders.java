package com.springboot.fulfillment.data.entity;


import java.util.Date;

import jakarta.persistence.*;
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
    @Column(name = "order_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    
    @Column(name = "order_id")
    private String orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_customer_no")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_goods_no")
    private Goods goods;
    
    @Column(name = "order_quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
    @Column(name = "update_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    
    @Column(name = "order_status", nullable = false)
    private Integer status;
    
    @Column(name = "order_price", nullable = false)
    private double price;
    
    @PreUpdate
    protected void onUpdate() {
        this.updateDate = new Date();
    }
}
