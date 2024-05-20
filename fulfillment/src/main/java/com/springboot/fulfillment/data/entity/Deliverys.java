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
public class Deliverys {

	@Id
	private String id;
	
	@ColumnDefault("0")
	private Integer quantity;
	
	@Column(nullable = false)
	private Integer status;
	
	// orders 쪽에서 여기로 FK 연결하고
}
