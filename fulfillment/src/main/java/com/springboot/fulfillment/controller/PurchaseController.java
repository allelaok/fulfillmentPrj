package com.springboot.fulfillment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.fulfillment.data.entity.Purchase;
import com.springboot.fulfillment.data.repository.PurchaseRepository;

@RestController
@RequestMapping("purchases")
public class PurchaseController {
	 @Autowired
	    private PurchaseRepository purchaseRepository;

	    @PostMapping
	    public Purchase addPurchase(@RequestBody Purchase purchase) {
	        return purchaseRepository.save(purchase);
	    }

//	    @PutMapping("/{id}")
//	    public ResponseEntity<Purchase> updatePurchase(@PathVariable("id") String id, @RequestBody Purchase purchase) {
//	        if (purchaseRepository.existsById(id)) {
//	            purchase.setPurchaseId(id);
//	            return ResponseEntity.ok(purchaseRepository.save(purchase));
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }

//	    @GetMapping("/{id}")
//	    public ResponseEntity<Purchase> getPurchase(@PathVariable String id) {
//	        Optional<Purchase> purchase = purchaseRepository.findById(id);
//	        return purchase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//	    }
}
