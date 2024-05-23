package com.springboot.fulfillment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.StockDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.entity.Storages;
import com.springboot.fulfillment.data.repository.SellerRepository;
import com.springboot.fulfillment.data.repository.StockRepository;
import com.springboot.fulfillment.data.repository.StorageRepository;

@Service
public class NSRStockService {
	
	Long storageNo = 1L;

	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private StorageRepository storageRepository;
	
	public Stock createStockAuto(String sellerId) {
	    Seller seller = sellerRepository.findBySellerIdContains(sellerId);
	    Optional<Storages> storage = storageRepository.findById(storageNo);
	    
	    Stock stock = Stock.builder()
                .storage(storage.get())
                .seller(seller)
                .build();
	    stock = stockRepository.save(stock);
		
	    return stock;
	}
}
