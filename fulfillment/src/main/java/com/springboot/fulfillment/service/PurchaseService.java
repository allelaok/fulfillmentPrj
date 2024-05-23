package com.springboot.fulfillment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.fulfillment.data.dto.PurchaseRequestDTO;
import com.springboot.fulfillment.data.dto.PurchaseResponseDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Purchase;
import com.springboot.fulfillment.data.repository.GoodsRepository;
import com.springboot.fulfillment.data.repository.PurchaseRepository;

@Service
public class PurchaseService {

	private PurchaseRepository purchaseRepository;
	private GoodsRepository goodsRepository;

	@Autowired
	public PurchaseService(PurchaseRepository purchaseRepository, GoodsRepository goodsRepository) {
		this.purchaseRepository = purchaseRepository;
		this.goodsRepository = goodsRepository;
	}

	 private WebClient webClient = WebClient.builder().baseUrl("http://manufacturer.api").build();
	 
	// Purchase 객체를 생성하여 제조사에게 전송하고 응답을 받은 후, 요청에 대한 DTO를 반환하는 메소드
	public PurchaseRequestDTO sendPurchase(Purchase purchase) {
		System.out.println("===PurchaseController-updatePurchase===");

		// purchase객체를 responsedto로 변환
		PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();
		purchaseResponseDTO.setFkProductId(purchase.getGoods().getNo());
		purchaseResponseDTO.setOrderQuantity(purchase.getQuantity());
		purchaseResponseDTO.setOrderDate(purchase.getPurchaseDate());
		purchaseResponseDTO.setOrderStatus(purchase.getPurchaseStatus());

		// webclient를 통해서 전송후에 반환되는 오더를 requestdto에 저장 후 리턴
		PurchaseRequestDTO purchaseRequestDTO = webClient.post()
                .uri("/order")//서버로 보낼 uri
                .bodyValue(purchaseResponseDTO)
                .header("sender", "Purchase")
                .retrieve()
                .bodyToMono(PurchaseRequestDTO.class)
                .block();

		return purchaseRequestDTO;
	}

	// Purchase 객체를 저장하는 메소드
	public void addPurchase(PurchaseRequestDTO purchaseRequestDTO) {
		System.out.println("===PurchaseController-updatePurchase===");

		// PurchaseRequestDTO를 Purchase 엔티티로 변환하여 저장하는 로직을 구현
		Purchase purchase = new Purchase();
		
//		purchase.setPurchaseId(purchaseRequestDTO.getOrder_id());// Long=>String으로 변환(header값추가)
		purchase.setPurchaseId(purchaseRequestDTO.getOrder_id().toString());		
		Optional<Goods> goodsOptional = goodsRepository.findById(purchaseRequestDTO.getFk_product_id());
		if(goodsOptional.isPresent()) {
			purchase.setGoods(goodsOptional.get());
		}else {
			throw new RuntimeException("Goods not found with id: " + purchaseRequestDTO.getFk_product_id());
		}
		
		purchase.setQuantity(purchaseRequestDTO.getOrder_quantity());
		purchase.setPurchaseDate(purchaseRequestDTO.getOrder_date());
		purchase.setPurchaseStatus(purchaseRequestDTO.getOrder_status());

		purchaseRepository.save(purchase);
	}

	// Purchase 객체를 업데이트하는 메소드
	public void updatePurchase(Purchase updatedPurchase) {
		System.out.println("===PurchaseController-updatePurchase===");

		// 업데이트할 Purchase 객체를 레퍼지토리의 save 메소드를 통해 저장하는 로직을 구현
		purchaseRepository.save(updatedPurchase);
	}

}
