package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	    @Column(name = "seller_id")
	    private String id;

	    @Column(name = "seller_pwd")
	    private String password;

	    @Column(name = "seller_name")
	    private String name;

	    @Column(name = "seller_contact")
	    private String contact;

	    @Column(name = "seller_email")
	    private String email;

	    @Column(name = "seller_company")
	    private String company;

	    @Column(name = "seller_regdate")
	    private Date registrationDate;

//	    @Column(name = "shoppingmall")
//	    private String shoppingMall;
}
