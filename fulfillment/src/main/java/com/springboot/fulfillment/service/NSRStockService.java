package com.springboot.fulfillment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.repository.StockRepository;

@Service
public class NSRStockService {

	@Autowired
	private StockRepository stockRepository;
}
