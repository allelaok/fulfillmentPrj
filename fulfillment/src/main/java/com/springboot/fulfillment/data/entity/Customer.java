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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_no")
	private Long no;

    @Column(name = "sh_customer_id", nullable = false)
    private String shId;


    @Column(name = "customer_name", nullable = false)
    private String name;
	
    @Column(name = "customer_contact", nullable = false)
    private String contact;

    @Column(name = "customer_zip_code", nullable = false)
    private int zipCode;

    @Column(name = "customer_street_address", nullable = false)
    private String streetAddress;

    @Column(name = "customer_detail_address", nullable = false)
    private String detailAddress;
}
