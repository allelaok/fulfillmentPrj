//package com.springboot.fulfillment.controller;
//
//import com.springboot.fulfillment.data.dto.KMSOrdersDTO;
//import com.springboot.fulfillment.service.KMSOrdersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/fulfilment/orders")
//public class KMSOrdersController {
//    private final KMSOrdersService kmsOrdersService;
//
//    @Autowired
//    public KMSOrdersController(KMSOrdersService kmsOrdersService) {
//        this.kmsOrdersService = kmsOrdersService;
//    }
//
//    @PostMapping
//    public void orderAdd(KMSOrdersDTO ordersDTO) {
//        KMSOrdersService.ordersAdd(ordersDTO);
//    }
//
//    @PutMapping
//    public void orderUpdate(@RequestBody KMSOrdersDTO ordersDTO) {
//        KMSOrdersService.ordersUpdate(ordersDTO);
//    }
//}
