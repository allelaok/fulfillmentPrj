package com.springboot.fulfillment.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> getStockList() {
        
        return stockRepository.findAll();
    }
	
	public Stock addStock(Stock stock) {
		return stockRepository.save(stock);
	}
	
	public Stock updateStock(String id, Stock stock) {
		if (stockRepository.existsById(id)) {
			stock.setId(id);
			return stockRepository.save(stock);
		}
		return null;
	}
	
	public List<Stock> getStockListByStatusAndRegdate(int status, Date regdate) {
		return stockRepository.findByStatusAndRegdate(status, regdate);
	}
	
	public long getStockCountByStatusAndRegdate(int status, Date regdate) {
		return stockRepository.countByStatusAndRegdate(status, regdate);
	}
}
