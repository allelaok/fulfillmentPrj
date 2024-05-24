package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.KMSSellerDTO;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("KMSSellersService")
public class KMSSellersService {

    private final SellerRepository sellerRepository;

    @Autowired
    public KMSSellersService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller sellerDetail(Long sellerNo) {
        Optional<Seller> result = sellerRepository.findById(sellerNo);
        if(result.isEmpty())
            return null;
        return result.get();
    }


}
