package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.fulfillment.data.dto.GoodsDTO;
import com.springboot.fulfillment.data.dto.KMSGoodsResponseDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.repository.GoodsRepository;
import com.springboot.fulfillment.data.repository.SellerRepository;
import com.springboot.fulfillment.data.repository.StockRepository;

@Service
public class NSRGoodsService {

	@Autowired
	private GoodsRepository goodsRepository;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private StockRepository stockRepository;

    private final WebClient webClient;
    
    // KMS
    @Autowired
    public NSRGoodsService() {
       
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:9010")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
    
    
	public List<GoodsDTO> getGoodsList(Long sellerNo) {
		Optional<Seller> seller = sellerRepository.findById(sellerNo);
		
		  if (seller.isEmpty()) {
	            return List.of();
	        }
		  
		List<Goods> goodsList = goodsRepository.findAllBySeller(seller.get());
		List<GoodsDTO> goodsDTOList = new ArrayList<>();
		for (Goods goods : goodsList) {
			GoodsDTO goodsDTO = new GoodsDTO();
			goodsDTO.fromGoods(goods);
			goodsDTOList.add(goodsDTO);
		}
		return goodsDTOList;
	}
	
	@Autowired
	private NSRStockService stockService;
	public GoodsDTO createGoods(String sellerId, GoodsDTO goodsDTO) {
		
	    Seller seller = sellerRepository.findBySellerIdContains(sellerId);
	    
	    Stock stock = stockService.createStockAuto(sellerId);
	    Goods newGoods = Goods.builder()
                .name(goodsDTO.getGoodsName())
                .img1(goodsDTO.getGoodsImg1())
                .img2(goodsDTO.getGoodsImg2())
                .code(goodsDTO.getGoodsCode())
                .description(goodsDTO.getGoodsDescription())
                .price(goodsDTO.getGoodsPrice())
                .seller(seller)
                .stock(stock)
                .build();

		System.out.println("엔티티 빌더 완료");
	    // Save the new goods
	    Goods result = goodsRepository.save(newGoods);

	    // KMS
	    KMSGoodsResponseDTO responseDTO = KMSGoodsResponseDTO.goodsResponseDTOFactory(result);
        System.out.println("test : " + responseDTO.toString());
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9010")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        webClient.post().uri("/shopping/goods")
                .bodyValue(responseDTO)
                .header("sender","fulfilment1")
                .retrieve()
                .toBodilessEntity()
                .block();
       
		GoodsDTO savedGoodsDTO = GoodsDTO.GoodsFactory(result);
		
	    return savedGoodsDTO;
	}

	public GoodsDTO getGoods(Long no) {
		Goods goods = goodsRepository.getById(no);

		GoodsDTO getGoodsDTO = GoodsDTO.GoodsFactory(goods);
		
		return getGoodsDTO;
	}
	
	// KMS
	public void deleteGoods(Long goodsNo) {
        Optional<Goods> goodsResult = goodsRepository.findById(goodsNo);
        if(goodsResult.isEmpty())
            return;
        Goods goods = goodsResult.get();
        KMSGoodsResponseDTO responseDTO = KMSGoodsResponseDTO.goodsResponseDTOFactory(goods);
        goodsRepository.delete(goods);

        webClient.delete().uri(uriBuilder -> uriBuilder
                        .path("/shopping/goods")
                        .queryParam("goodsCode", responseDTO.getGoodsCode())
                        .queryParam("sellerContact", responseDTO.getSellerContact())
                        .build())
                .header("sender","fulfilment1")
                .retrieve()
                .toBodilessEntity()
                .subscribe(response -> {
                    if (response.getStatusCode().is2xxSuccessful()) {
                        System.out.println("삭제 성공");
                    } else {
                        System.out.println("삭제 실패");
                    }});
    }
	
	public KMSGoodsResponseDTO updateGoods(GoodsDTO goodsDTO) {

				Optional<Goods> goods = goodsRepository.findById(goodsDTO.getGoodsNo());
				System.out.println(goods.get().getCode());

				System.out.println(goods.get().getRegTime());
				
			    Goods newGoods = goodsDTO.fill(goods.get(), null, null);

				System.out.println(goods.get().getCode());
				
				
				System.out.println("====================");
				

				System.out.println(goods.get().getRegTime());
				System.out.println(newGoods.getImg1());
			    // Save the new goods
			    Goods fixGoods = goodsRepository.save(newGoods);
//			    // KMS
			    KMSGoodsResponseDTO responseDTO = KMSGoodsResponseDTO.goodsResponseDTOFactory(fixGoods);
		        webClient.put().uri("/shopping/goods")
		                .bodyValue(responseDTO)
		                .header("sender","fulfilment1")
		                .retrieve()
		                .toBodilessEntity()
		                .block();

			    return responseDTO;
	}
}
