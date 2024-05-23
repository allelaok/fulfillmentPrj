package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("KMSGoodsService")
public class KMSGoodsService {
    private final GoodsRepository goodsRepository;

    @Autowired
    public KMSGoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }


}
