package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Customer;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
	private Long id;
	
	private String name;
	
	private String contact;
	
	private Long zipCode;

	private String streetAddress;
	
	private String detailAddress;
	

	public CustomerDTO fromCustomer(Customer customer) {
		this.id = customer.getCustomerId();
		this.name = customer.getName();
		this.contact = customer.getContact();
		this.zipCode = customer.getZipCode();
		this.streetAddress = customer.getStreetAddress();
		this.detailAddress = customer.getDetailAddress();
		return this;
	}
	

	public Customer fill(Customer customer) {
		customer.setCustomerId(this.id);
		customer.setName(this.name);
		customer.setContact(this.contact);
		customer.setZipCode(this.zipCode);
		customer.setStreetAddress(this.streetAddress);
		customer.setDetailAddress(this.detailAddress);
		
		
		return customer;
	}
	
}