package com.springboot.fulfillment.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private String id;
	
	@ColumnDefault("0")
	@Column(name = "delivery_quantity")
	private Integer quantity;
	
	@Column(nullable = false, name = "delivery_status")
	private Integer status;
	
	// orders 쪽에서 여기로 FK 연결하고
}
