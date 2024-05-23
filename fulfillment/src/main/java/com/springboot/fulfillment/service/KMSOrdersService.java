package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("KMSOrdersService")
public class KMSOrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public KMSOrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


}
