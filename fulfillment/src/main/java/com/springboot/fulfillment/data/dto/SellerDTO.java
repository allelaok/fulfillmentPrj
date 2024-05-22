package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Seller;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SellerDTO {

	private Long id;
//	private Long sellerId;
	private String sellerId;
	private String name;
	private String contact;
	private String company;
    private String shoppingMall;


	public SellerDTO from( Seller seller ) {
		this.id = seller.getId();
		this.sellerId = seller.getSellerId();
		this.name = seller.getName();
		this.contact = seller.getContact();
		this.company = seller.getCompany();
		this.shoppingMall = seller.getShoppingMall();
//		this.insertDateTime = .getInsertDateTime();
		return this;
	}
	
	public static SellerDTO Factory(Seller seller) {
		SellerDTO sellerDTO = new SellerDTO();
		sellerDTO.from(seller);
		return sellerDTO;
	}
	
	public Seller fill( Seller seller) {
		seller.setSellerId(this.sellerId);
		seller.setName(this.name);
		seller.setContact(this.contact);
		seller.setCompany(this.company);
		seller.setShoppingMall(this.shoppingMall);
		return seller;
	}

}
