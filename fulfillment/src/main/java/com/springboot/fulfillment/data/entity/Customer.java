package com.springboot.fulfillment.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "customer")
public class Customer {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "customer_contact")
	private String contact;
	
	@Column(name = "customer_zip_code")
	private Long zipCode;

	@Column(name = "customer_street_address")
	private String streetAddress;
	
	@Column(name = "customer_detail_address")
	private String detailAddress;
}
