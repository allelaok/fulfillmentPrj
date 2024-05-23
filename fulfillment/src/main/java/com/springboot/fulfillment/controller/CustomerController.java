package com.springboot.fulfillment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.fulfillment.data.dto.CustomerDTO;
import com.springboot.fulfillment.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/{no}")
	public String getCustomer(@PathVariable("no") Long no, Model model) {
    	CustomerDTO customer = customerService.getCustomer(no);
    	model.addAttribute("customer", customer);
    	return "home";
	}
  

    @PostMapping("/create")
    public String addCustomer(CustomerDTO customerDTO) {
    	    	
    	customerService.addCustomer(customerDTO);
    	
		return "home";
    }
    



//    @PutMapping("/customer/update")
//    public String updateCustomer(CustomerDTO customerDTO) {
//    	customerService.updateCustomer(customerDTO);
//		return "home";
//    }
    
}
