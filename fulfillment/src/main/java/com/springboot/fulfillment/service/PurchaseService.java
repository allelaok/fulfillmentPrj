package com.springboot.fulfillment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.springboot.fulfillment.data.dto.PurchaseRequestDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Purchase;
import com.springboot.fulfillment.data.repository.GoodsRepository;
import com.springboot.fulfillment.data.repository.PurchaseRepository;

import reactor.core.publisher.Mono;

@Service
public class PurchaseService {

	private PurchaseRepository purchaseRepository;
	private GoodsRepository goodsRepository;
	private WebClient webClient;
	
	@Autowired
	public PurchaseService(PurchaseRepository purchaseRepository, GoodsRepository goodsRepository, WebClient.Builder webClientBuilder) {
		this.purchaseRepository = purchaseRepository;
		this.goodsRepository = goodsRepository;
		this.webClient = webClientBuilder.baseUrl("http://localhost:9000").build();
	}


	// Purchase 객체를 생성하여 제조사에게 전송하고 응답을 받은 후, 요청에 대한 DTO를 반환하는 메소드
	public PurchaseRequestDTO sendPurchase(PurchaseRequestDTO purchase) {
		System.out.println("===PurchaseController-sendPurchase===");

//		PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();
//		purchaseResponseDTO.setFk_product_id(purchase.getFk_product_id());
//		purchaseResponseDTO.setOrder_quantity(purchase.getOrder_quantity());
//		purchaseResponseDTO.setOrder_date(purchase.getOrder_date());
//		purchaseResponseDTO.setOrder_status(purchase.getOrder_status());
		// webclient를 통해서 전송후에 반환되는 오더를 requestdto에 저장 후 리턴
	       try {
	            PurchaseRequestDTO purchaseRequestDTO = webClient.post().uri("/order")
	                .bodyValue(purchase)
	                .header("sender", "Purchase")
	                .retrieve()
	                .onStatus(
	                    status -> status.isError(),
	                    clientResponse -> {
	                        System.out.println("Error: " + clientResponse.statusCode());
	                        return clientResponse.bodyToMono(String.class).flatMap(errorBody -> {
	                            System.out.println("Error Body: " + errorBody);
	                            return Mono.error(new RuntimeException("Failed to send purchase order: " + clientResponse.statusCode()));
	                        });
	                    }
	                )
	                .bodyToMono(PurchaseRequestDTO.class)
	                .block();

	            return purchaseRequestDTO;
	        } catch (WebClientResponseException e) {
	            System.out.println("WebClientResponseException: " + e.getMessage());
	            // handle WebClientResponseException
	        } catch (Exception e) {
	            System.out.println("Exception: " + e.getMessage());
	            // handle other exceptions
	        }
		return purchase;
		
		
//		PurchaseRequestDTO purchaseRequestDTO = webClient.post().uri("/order")
//				.bodyValue(purchase).header("sender", "Purchase")
//				.exchangeToMono(response -> {
//					if(response.statusCode().is2xxSuccessful()) {
//						return response.bodyToMono(PurchaseRequestDTO.class);
//					}else {
//						System.out.println("errrrrrrrrrrrrrrrrrr: " + response.createException().flatMap(Mono::error));
//						return response.bodyToMono(PurchaseRequestDTO.class);
//					}
//				})
//				.block();
		

//		return purchaseRequestDTO;
	}

	// Purchase 객체를 저장하는 메소드
	public void addPurchase(PurchaseRequestDTO purchaseRequestDTO) {
		System.out.println("===PurchaseController-addPurchase===");

		// PurchaseRequestDTO를 Purchase 엔티티로 변환하여 저장하는 로직을 구현
		Purchase purchase = new Purchase();

//		purchase.setPurchaseId(purchaseRequestDTO.getOrder_id());// Long=>String으로 변환(header값추가)
		purchase.setPurchaseId(purchaseRequestDTO.getOrder_id().toString());
		Optional<Goods> goodsOptional = goodsRepository.findById(purchaseRequestDTO.getFk_product_id());
		if (goodsOptional.isPresent()) {
			purchase.setGoods(goodsOptional.get());
		} else {
			throw new RuntimeException("Goods not found with id: " + purchaseRequestDTO.getFk_product_id());
		}

		purchase.setQuantity(purchaseRequestDTO.getOrder_quantity());
		purchase.setPurchaseDate(purchaseRequestDTO.getOrder_date());
		purchase.setPurchaseStatus(purchaseRequestDTO.getOrder_status());

		purchaseRepository.save(purchase);
	}

	// Purchase 객체를 업데이트하는 메소드
	public void updatePurchase(PurchaseRequestDTO updatedPurchase) {
		System.out.println("===PurchaseController-updatePurchase===");

		Optional<Goods> goods = goodsRepository.findById(updatedPurchase.getFk_product_id());
		
		
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(updatedPurchase.getOrder_id().toString());
		if (goods.isPresent()) {
			purchase.setGoods(goods.get());
		} else {
			throw new RuntimeException();
		}
		purchase.setPurchaseDate(updatedPurchase.getOrder_date());
		purchase.setPurchaseStatus(updatedPurchase.getOrder_status());
		purchase.setQuantity(updatedPurchase.getOrder_quantity());
		
		
		
		
		// 업데이트할 Purchase 객체를 레퍼지토리의 save 메소드를 통해 저장하는 로직을 구현
		purchaseRepository.save(purchase);
	}

}
