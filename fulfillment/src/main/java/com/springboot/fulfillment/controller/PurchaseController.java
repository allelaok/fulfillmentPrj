package com.springboot.fulfillment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.fulfillment.data.dto.PurchaseRequestDTO;
import com.springboot.fulfillment.data.entity.Purchase;
import com.springboot.fulfillment.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	private PurchaseService purchaseService;

	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	// body를 통해서 들어온 purchase객체를 통해 서비스에 전송하여 응답받은 id가 담겨있는 responseDTO를 통해 풀필먼트테이블에 저장
	@PostMapping
	public void addPurchase(@RequestBody PurchaseRequestDTO purchase) {
		System.out.println("===PurchaseController-addPurchase===");
		
		// 서비스로 객체를 보내어 dto로 변경하여 서버로전송(제조사)
		PurchaseRequestDTO purchaseRequestDTO = purchaseService.sendPurchase(purchase);

		// 응답받은 requestDTO를 통해서 풀필먼트테이블에 저장
		purchaseService.addPurchase(purchaseRequestDTO);
	}

	// 전달받은 업데이트발주요청(상태변화)를 서비스에 전달하여 저장
	@PutMapping
	public ResponseEntity<String> updatePurchase(@RequestBody Purchase updatedPurchase) {
		System.out.println("===PurchaseController-updatePurchase===");
		
		// 전달받은 업데이트발주요청(상태변화)를 서비스에 전달하여 저장
		purchaseService.updatePurchase(updatedPurchase);

		return ResponseEntity.ok("Purchase updated successfully");
	}

}
