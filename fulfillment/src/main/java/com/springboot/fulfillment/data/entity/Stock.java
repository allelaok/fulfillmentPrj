package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
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
@Table(name = "stock")
@Check(constraints = "quality >= 1 AND quality <= 5")
public class Stock {
	@Id
	@Column(name = "stock_id")
	private String id;
	
	@ColumnDefault("0")
	@Column(name = "stock_quantity")
	private Integer quantity;
	
	@Column(nullable = false, name = "stock_regdate")
	private Date regdate;
	
	@Column(nullable = false, name = "stock_status")
	private Integer status;
	
	@Column(nullable = false, name = "stock_quality")
	private Integer quality;
	// FK 세개
}
