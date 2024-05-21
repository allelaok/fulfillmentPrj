package com.springboot.fulfillment.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fulfillment.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
