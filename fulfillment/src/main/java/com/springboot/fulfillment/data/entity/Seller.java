package com.springboot.fulfillment.data.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
public class Seller {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "seller_no")
	    private Long no;

	    @Column(name = "seller_id", nullable = false)
	    private String sellerId;

	    @Column(name = "seller_pwd", nullable = false)
	    private String password;

	    @Column(name = "seller_name", nullable = false)
	    private String name;

	    @Column(name = "seller_contact", unique = true, nullable = false)
	    private String contact;

	    @Column(name = "seller_email", nullable = false)
	    private String email;

	    @Column(name = "seller_company", nullable = false)
	    private String company;

	    @Column(name = "seller_regdate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date regDate;

	    @Column(name = "seller_shop", nullable = false)
	    private String shop;
	   
}
