package com.springboot.fulfillment.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seller")
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
