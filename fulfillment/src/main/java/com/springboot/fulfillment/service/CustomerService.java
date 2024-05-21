package com.springboot.fulfillment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomerList() {
        // 상품 목록 가져오기
        return customerRepository.findAll();
    }
	
	public void addCustomer(Customer customer) {
        // 상품 등록
		customerRepository.save(customer);
    }
}
