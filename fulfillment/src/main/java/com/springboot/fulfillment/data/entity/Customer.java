package com.springboot.fulfillment.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, name = "sh_customer_id")
	private String shId;
	
	@Column(nullable = false, name = "customer_name")
	private String name;
	
	@Column(nullable = false, name = "customer_contact")
	private String contact;
	
	@Column(nullable = false, name = "customer_zip_code")
	private Integer zip_code;

	@Column(nullable = false, name = "customer_street_address")
	private String street_address;
	
	@Column(nullable = false, name = "customer_detail_address")
	private String detail_address;
}
