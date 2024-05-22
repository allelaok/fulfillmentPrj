package com.springboot.fulfillment.data.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	    @Column(name = "id")
	    private Long id;
	 	
	    @Column(name = "seller_id")
	    private String sellerId;

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

	    @Column(name = "shoppingmall")
	    private String shoppingMall;
}
