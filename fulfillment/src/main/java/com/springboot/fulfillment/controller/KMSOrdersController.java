package com.springboot.fulfillment.controller;

import com.springboot.fulfillment.data.dto.OrdersDTO;
import com.springboot.fulfillment.service.KMSOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fulfilment/orders")
public class KMSOrdersController {
    private final KMSOrdersService kmsOrdersService;

    @Autowired
    public KMSOrdersController(KMSOrdersService kmsOrdersService) {
        this.kmsOrdersService = kmsOrdersService;
    }

    @PostMapping
    public void orderAdd(@RequestBody OrdersDTO ordersDTO, @RequestHeader("sender") String header) throws Exception {
        kmsOrdersService.ordersAdd(ordersDTO, header);
    }

    @PutMapping
    public void orderUpdate(@RequestBody OrdersDTO ordersDTO) {
        System.out.println("주문 수정");
        kmsOrdersService.ordersUpdate(ordersDTO);
    }
}
