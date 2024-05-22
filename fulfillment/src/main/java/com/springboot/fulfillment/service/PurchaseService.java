package com.springboot.fulfillment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.PurchaseCreateDTO;
import com.springboot.fulfillment.data.entity.Purchase;
import com.springboot.fulfillment.data.repository.PurchaseRepository;

@Service
public class PurchaseService {

//	addPurchase(purchaseCreateDTO)
//	updatePurchase(purchaseUpdateDTO)
//	getPurchase(purchaseId)
	
    @Autowired
    private PurchaseRepository purchaseRepository;

    public void addPurchase(PurchaseCreateDTO purchaseCreateDTO) {

    	Purchase purchase = Purchase.builder()
//				.purchaseId(purchaseCreateDTO.getPurchaseId())
//				.goodsId(purchaseCreateDTO.getGoodsId())
				.quantity(purchaseCreateDTO.getQuantity())
				.status(purchaseCreateDTO.getStatus())
				.build();
    	
		this.purchaseRepository.save(purchase);
    }

//    public void updatePurchase(PurchaseUpdateDTO purchaseUpdateDTO) {
//    	Purchase purchase = this.purchaseRepository.findById(purchaseUpdateDTO.getPurchaseId()).orElseThrow();
//    	purchase = purchaseUpdateDTO.fill(purchase);
//		this.purchaseRepository.save(purchase);
//    }
//
//    public PurchaseReadResponseDTO getPurchase(String puchaseId) throws NoSuchElementException{
//        // 발주 상세정보 가져오기
//        Purchase purchase = purchaseRepository.findById(puchaseId).orElseThrow();
//        
//        PurchaseReadResponseDTO purchaseReadResponseDTO = new PurchaseReadResponseDTO();
//        purchaseReadResponseDTO.fromPurchase(purchase);
//        return purchaseReadResponseDTO;
//    }
}
