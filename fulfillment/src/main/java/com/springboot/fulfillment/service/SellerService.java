package com.springboot.fulfillment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.SellerDTO;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public Seller getSeller(String sellerId) {
		return sellerRepository.findBySellerIdContains(sellerId);
	}
	

	public void addSeller(SellerDTO sellerDTO) {

		Seller seller = Seller.builder()
				.id(sellerDTO.getId())
				.build();

		sellerRepository.save(seller);
	}
	
	public Seller getSellerIdByContact(SellerDTO sellerDTO) {
		   return sellerRepository.findByContactContains(sellerDTO.getContact());
		}
	
	
//	public List<Seller> getSellerList() {
//        
//        return sellerRepository.findAll();
//    }
}
