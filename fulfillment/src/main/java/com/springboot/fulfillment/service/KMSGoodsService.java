package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.KMSGoodsDTO;
import com.springboot.fulfillment.data.dto.KMSStockDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.entity.Storages;
import com.springboot.fulfillment.data.repository.GoodsRepository;
import com.springboot.fulfillment.data.repository.StockRepository;
import com.springboot.fulfillment.data.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("KMSGoodsService")
public class KMSGoodsService {
    private final GoodsRepository goodsRepository;
    private final SellerService sellerService;
    private final KMSStockService kmsStockService;
    private final StorageRepository storageRepository;

    @Autowired
    public KMSGoodsService(GoodsRepository goodsRepository, SellerService sellerService, KMSStockService kmsStockService, StorageRepository storageRepository) {
        this.goodsRepository = goodsRepository;
        this.sellerService = sellerService;
        this.kmsStockService = kmsStockService;
        this.StorageRepository = storageRepository;
    }

    public void goodsUpdate(KMSGoodsDTO goodsDTO) throws Exception {
        Seller seller = sellerService.getSeller(goodsDTO.getSellerId());
        KMSStockDTO kmsStockDTO = kmsStockService.stockDetail(goodsDTO.getGoodsStock());

        Stock stock = new Stock();

        //stock 아이디 가져오기
        //stock.setNo();
        stock.setWStockId(kmsStockDTO.getWStockNo());
        stock.setQuantity(kmsStockDTO.getQuantity());
        stock.setRegDate(kmsStockDTO.getRegdate());
        stock.setSeller(seller);

        Optional<Storages> storages = storageRepository.findById(kmsStockDTO.getStorageNo());
        stock.setStorage(storages.get());




        Goods goods = Goods.builder()
                .code(goodsDTO.getGoodsCode())
                .name(goodsDTO.getGoodsName())
                .price(goodsDTO.getGoodsPrice())
                .description(goodsDTO.getGoodsDescription())
                .img1(goodsDTO.getGoodsImg1())
                .img2(goodsDTO.getGoodsImg2())
                .seller(seller)
                .stock(stock)
                .build();
    }
}
