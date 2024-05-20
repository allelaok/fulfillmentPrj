package com.springboot.fulfillment.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private String id;
	
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
