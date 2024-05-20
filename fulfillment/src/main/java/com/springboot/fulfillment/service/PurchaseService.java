package com.springboot.fulfillment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.entity.Purchase;
import com.springboot.fulfillment.data.repository.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public void addPurchase(Purchase purchase) {
        // 발주 정보 등록
        purchaseRepository.save(purchase);
    }

    public void updatePurchase(Purchase purchase) {
        // 발주 정보 수정
        purchaseRepository.save(purchase);
    }

    public Purchase getPurchase(String purchaseId) {
        // 발주 상세정보 가져오기
        return purchaseRepository.findById(purchaseId).orElse(null);
    }
}
