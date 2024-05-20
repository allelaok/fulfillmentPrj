package com.springboot.fulfillment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
    private OrdersService ordersService;

    @GetMapping("/status/{status}")
    public List<Orders> getOrderListByStatus(@PathVariable int status) {
        return ordersService.getOrderListByStatus(status);
    }

    @GetMapping("/count/status/{status}")
    public long getOrderByStatus(@PathVariable String status) {
        return ordersService.getOrderByStatus(status);
    }

    @GetMapping
    public List<Orders> getOrderList() {
        return ordersService.getOrderList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderDetail(@PathVariable String id) {
        Optional<Orders> order = ordersService.getOrderDetail(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orders addOrder(@RequestBody Orders order) {
        return ordersService.addOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable String id, @RequestBody Orders order) {
        Orders updatedOrder = ordersService.updateOrder(id, order);
        return updatedOrder != null ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
    }
}
