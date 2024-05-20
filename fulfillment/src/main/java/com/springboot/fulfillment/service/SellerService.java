package com.springboot.fulfillment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.repository.SellerRepository;

public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public List<Seller> getSellerList() {
        // 상품 목록 가져오기
        return sellerRepository.findAll();
    }
}
