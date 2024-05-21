package com.springboot.fulfillment.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "delivery")
public class Delivery {

	@Id
	@Column(name = "delivery_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, name = "d_delivery_id")
	private String dDeliveryId;
	
	@Column(name = "fk_order_id")
    private String orderId;
    
    @ManyToOne
    @JoinColumn(name = "fk_order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private Orders order;
	
	@ColumnDefault("0")
	@Column(name = "delivery_quantity")
	private Integer quantity;
	
	@Column(nullable = false, name = "delivery_status")
	private Integer status;
	
	// orders 쪽에서 여기로 FK 연결하고
}
