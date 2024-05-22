package com.springboot.fulfillment.controller;

import java.sql.Date;
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
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
    private StockService stockService;

    @GetMapping("/status/{status}")
    public List<Stock> getStockListByStatusAndRegdate(@PathVariable int status, @PathVariable Date regdate) {
        return stockService.getStockListByStatusAndRegdate(status, regdate);
    }

    @GetMapping("/count/status/{status}")
    public long getStockCountByStatusAndRegdate(@PathVariable int status, @PathVariable Date regdate) {
        return stockService.getStockCountByStatusAndRegdate(status, regdate);
    }

    @GetMapping
    public List<Stock> getStockList() {
        return stockService.getStockList();
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable String id, @RequestBody Stock stock) {
        Stock updatedStock = stockService.updateStock(id, stock);
        return updatedStock != null ? ResponseEntity.ok(updatedStock) : ResponseEntity.notFound().build();
    }
	
}
