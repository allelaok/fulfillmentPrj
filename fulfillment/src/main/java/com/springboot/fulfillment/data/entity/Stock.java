package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.EqualsAndHashCode;
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
public class Stock {
	@Id
	private String id;
	
	@ColumnDefault("0")
	private Integer quantity;
	
	@Column(nullable = false)
	private Date regdate;
	
	@Column(nullable = false)
	private Integer status;
	
	@Column(nullable = false)
	private Integer quality;
	// FK 세개
}
