package com.springboot.fulfillment.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.fulfillment.data.dto.DeliveryCreateDTO;
import com.springboot.fulfillment.data.dto.DeliveryListResponseDTO;
import com.springboot.fulfillment.data.dto.DeliveryReadResponseDTO;
import com.springboot.fulfillment.data.dto.DeliveryUpdateDTO;
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
         return "deliveryList"; // 추후 html에 만들어 놓기
    }
	
	@GetMapping("/read/{id}")
    public String getDelivery(@PathVariable("id") Integer id, Model model) {
        try {
        	DeliveryReadResponseDTO deliveryReadResponseDTO = this.deliveryService.getDeliveryDetail(id);
            model.addAttribute("deliveryReadResponseDTO", deliveryReadResponseDTO);
            return "deliveryRead";
        } catch (NoSuchElementException ex) {
        	return "home";
            // 에러 처리
//            return "errorPage"; // 에러 페이지로 리다이렉트 또는 에러 처리 로직 추가
        }
    }
	
	@GetMapping("/create")
	public String create() {
		return "deliveryCreate";
	}
	
	@PostMapping("/create")
    public String addDelivery(DeliveryCreateDTO deliveryCreateDTO) {
        deliveryService.addDelivery(deliveryCreateDTO);
		return "deliveryList";
    }
	
	@GetMapping("/update")
	public String update() {
		return "deliveryUpdate";
	}
	
	@PutMapping("/update")
    public String updateDelivery(DeliveryUpdateDTO deliveryUpdateDTO) {
		deliveryService.updateDelivery(deliveryUpdateDTO);
		return "deliveryList";
    }
}
