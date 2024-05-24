package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.CustomerDTO;
import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("KMSCustomerService")
public class KMSCustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public KMSCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByShId(String header, Long shCustomerId) throws Exception{
        return customerRepository.findByShIdContains(header + "_" + shCustomerId);
    }
}
