package com.springboot.fulfillment.controller;

import com.springboot.fulfillment.data.dto.KMSGoodsDTO;
import com.springboot.fulfillment.service.KMSGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fulfillment/orders")
public class KMSGoodsController {
    private final KMSGoodsService kmsGoodsService;

    @Autowired
    public KMSGoodsController(KMSGoodsService kmsGoodsService) {
        this.kmsGoodsService = kmsGoodsService;
    }

    @PostMapping
    public void goodsAdd(@RequestBody KMSGoodsDTO goodsDTO) {
        KMSGoodsService.goodsAdd(goodsDTO);
    }

    @PutMapping
    public void goodsUpdate(@RequestBody KMSGoodsDTO goodsDTO) {
        KMSGoodsService.goodsUpdate(goodsDTO);
    }

    @DeleteMapping
    public void goodsDelete(@RequestParam Long goodsNo, @RequestParam String sellerContact) {
        KMSGoodsService.goodsDelete(goodsNo, sellerContact);
    }
}
