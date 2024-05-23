//package com.springboot.fulfillment.service;
//
//import com.springboot.fulfillment.data.dto.KMSStockDTO;
//import com.springboot.fulfillment.data.entity.Stock;
//import com.springboot.fulfillment.data.repository.StockRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service("KMSStockService")
//public class KMSStockService {
//
//    private StockRepository stockRepository;
//
//    @Autowired
//    public KMSStockService(StockRepository stockRepository) {
//        this.stockRepository = stockRepository;
//    }
//
//    public KMSStockDTO stockDetail(Long goodsStock) throws Exception {
//        Optional<Stock> result = stockRepository.findById(goodsStock);
//
//        if(!(result.isPresent()))
//            return null;
//        Stock stock = Stock
//
//    }
//}
