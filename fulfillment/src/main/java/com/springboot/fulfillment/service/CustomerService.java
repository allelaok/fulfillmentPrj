package com.springboot.fulfillment.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.CustomerDTO;
import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerDTO getCustomer(Long customerId) throws NoSuchElementException{
		Customer customer = this.customerRepository.findById(customerId).orElseThrow();
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.fromCustomer(customer);
		
        return customerDTO;
    }
	
	public void addCustomer(CustomerDTO customerDTO) {
		Customer customer = Customer.builder()
				.name(customerDTO.getName())
				.contact(customerDTO.getContact())
//				.zipCode(customerDTO.getZipCode())
				.streetAddress(customerDTO.getStreetAddress())
				.detailAddress(customerDTO.getDetailAddress()) 
				.build();
		// 상품 등록
		this.customerRepository.save(customer);
    }
	
	public void updateCustomer(CustomerDTO customerDTO) {
		Customer customer = this.customerRepository.findById(customerDTO.getId()).orElseThrow();
		customer = customerDTO.fill(customer);
		this.customerRepository.save(customer);
    }
}
