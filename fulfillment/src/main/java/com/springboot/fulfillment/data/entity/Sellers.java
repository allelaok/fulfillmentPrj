package com.springboot.fulfillment.data.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "seller")
public class Sellers {
	
	@Id
	private String id;
	
	@Column(nullable = false)
	private String pwd;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String contact;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String company;
	
	@Column(nullable = false)
	private Date regdate;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "seller_id")
	private List<Stock> stocks = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "seller_id")
	private List<Goods> goods = new ArrayList<>();
}
