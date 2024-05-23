package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.KMSOrdersResponseDTO;
import com.springboot.fulfillment.data.dto.OrdersDTO;
import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service("KMSOrdersService")
public class KMSOrdersService {
    private final OrdersRepository ordersRepository;
    private final KMSGoodsService goodsService;
    private final KMSCustomerService customerService;
    private final WebClient webClient;


    @Autowired
    public KMSOrdersService(OrdersRepository ordersRepository, KMSGoodsService goodsService, KMSCustomerService customerService) {
        this.ordersRepository = ordersRepository;
        this.goodsService =  goodsService;
        this.customerService = customerService;
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:9010")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void ordersAdd(OrdersDTO ordersDTO, String header) throws Exception {
        Customer customer = customerService.findByShId(header, ordersDTO.getCustomerNo());

        Goods goods = goodsService.findByGoodsCode(ordersDTO.getGoodsCode());

        Orders orders = Orders.builder()
                .orderId(header + "_" + ordersDTO.getOrderId())
                .quantity(ordersDTO.getQuantity())
                .orderDate(ordersDTO.getOrderDate())
                .status(ordersDTO.getStatus())
                .price(ordersDTO.getOrderPrice())
                .goods(goods)
                .customer(customer)
                .build();

        ordersRepository.save(orders);
    }

    public void ordersUpdate(OrdersDTO ordersDTO) {
        Optional<Orders> result = ordersRepository.findById(ordersDTO.getNo());
        if(result.isEmpty())
            return;
        Orders orders = result.get();
        String[] temp = orders.getOrderId().split("_");

        KMSOrdersResponseDTO responseDTO = KMSOrdersResponseDTO.builder()
                .orderId(Long.valueOf(temp[1]))
                .orderStatus(Long.valueOf(ordersDTO.getStatus()))
                .build();

        webClient.put().bodyValue(responseDTO)
                .header("sender","fulfilment1")
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
