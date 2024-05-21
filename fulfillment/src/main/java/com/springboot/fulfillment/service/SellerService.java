package com.springboot.fulfillment.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.fulfillment.data.dto.SellerDTO;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.repository.SellerRepository;

public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public Seller getSeller(String sellerId) {
		return sellerRepository.findByIdContains(sellerId);
	}
	

	public void addSeller(SellerDTO sellerDTO) {

		Seller seller = Seller.builder().id(sellerDTO.getSellerId()).build();

		sellerRepository.save(seller);
	}
	
	
//	public List<Seller> getSellerList() {
//        
//        return sellerRepository.findAll();
//    }
}
