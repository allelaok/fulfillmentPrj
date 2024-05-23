package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.KMSStockDTO;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("KMSStockService")
public class KMSStockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStockList() {

        return stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public KMSStockDTO stockDetail(Long goodsStock) throws Exception {

        Optional<Stock> stock = stockRepository.findById(goodsStock);
        KMSStockDTO kmsStockDTO = new KMSStockDTO();

        if(stock.isPresent()){
            kmsStockDTO.setWStockNo(stock.get().getWStockId());
            kmsStockDTO.setQuantity(stock.get().getQuantity());
            kmsStockDTO.setRegdate(stock.get().getRegDate());
            kmsStockDTO.setSellerNo(stock.get().getSeller().getSellerId());
            kmsStockDTO.setStorageNo(stock.get().getStorage().getNo());
        }else{

        }

        return kmsStockDTO;
    }
}
