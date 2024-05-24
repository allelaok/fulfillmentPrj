package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KMSSellerDTO {

    private Long no;
    private String sellerId;
    private String password;
    private String name;
    private String contact;
    private String email;
    private String company;
    private Date regDate;
    private String shop;

    private KMSSellerDTO fromSeller(Seller seller) {
        this.no = seller.getNo();
        this.sellerId = seller.getSellerId();
        this.password = seller.getPassword();
        this.name = seller.getName();
        this.contact = seller.getContact();
        this.email = seller.getEmail();
        this.company = seller.getCompany();
        this.regDate = seller.getRegDate();
        this.shop = seller.getShop();
        return this;
    }

    public static KMSSellerDTO sellerFactory(Seller seller) {
        KMSSellerDTO kmsSellerDTO = new KMSSellerDTO();
        kmsSellerDTO.fromSeller(seller);
        return kmsSellerDTO;
    }
}
