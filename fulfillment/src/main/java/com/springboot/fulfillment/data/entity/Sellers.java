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
	@Column(name = "seller_id")
	private String id;
	
	@Column(nullable = false, name = "seller_pwd")
	private String pwd;
	
	@Column(nullable = false, name = "seller_name")
	private String name;
	
	@Column(nullable = false, name = "seller_contact", unique = true)
	private String contact;
	
	@Column(nullable = false, name = "seller_email")
	private String email;
	
	@Column(nullable = false, name = "seller_company")
	private String company;
	
	@Column(nullable = false, name = "seller_regdate")
	private Date regdate;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private List<Stock> stocks = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private List<Goods> goods = new ArrayList<>();
}
