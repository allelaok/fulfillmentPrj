package com.springboot.fulfillment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.fulfillment.data.dto.DeliveryListResponseDTO;
import com.springboot.fulfillment.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
    private DeliveryService deliveryService;
	
	@GetMapping("/list")
    public String getDeliveryList(Model model) {
         List<DeliveryListResponseDTO> deliveryList = deliveryService.getDeliveryList();
         model.addAttribute("deliveryList", deliveryList);
         return "deliveryList";
    }
}
