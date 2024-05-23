package com.springboot.fulfillment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springboot.fulfillment.data.dto.CustomerDTO;
import com.springboot.fulfillment.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    

//    @PostMapping("/customer/create")
//    public String addCustomer(CustomerDTO customerDTO) {
//    	    	
//    	customerService.addCustomer(customerDTO);
//    	
//		return "home";
//    }
    

//    @GetMapping("/getCustomer/{customerId}")
//    public String getCustomer(@PathVariable("customerId") Long customerId,Model model) {
//    	    	
//       CustomerDTO customer = customerService.getCustomer(customerId);
//        model.addAttribute("customer", customer);
//        return "home";
//    }
//    

//    @PutMapping("/customer/update")
//    public String updateCustomer(CustomerDTO customerDTO) {
//    	customerService.updateCustomer(customerDTO);
//		return "home";
//    }
    
}
