package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.KMSGoodsDTO;
import com.springboot.fulfillment.data.dto.KMSGoodsResponseDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service("KMSGoodsService")
public class KMSGoodsService {
    private final GoodsRepository goodsRepository;
    private final KMSStockService stockService;
    private final KMSSellersService sellerService;
    private final WebClient webClient;

    @Autowired
    public KMSGoodsService(GoodsRepository goodsRepository, KMSStockService stockService, KMSSellersService sellerService) {
        this.goodsRepository = goodsRepository;
        this.stockService = stockService;
        this.sellerService = sellerService;
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:9010")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void goodsAdd(KMSGoodsDTO goodsDTO) throws Exception {
        Seller seller = sellerService.sellerDetail(goodsDTO.getSellerNo());

        Stock stock = stockService.stockDetail(goodsDTO.getStockNo());

        Goods goods = Goods.builder()
                .code(goodsDTO.getGoodsCode())
                .name(goodsDTO.getGoodsName())
                .price(goodsDTO.getGoodsPrice())
                .description(goodsDTO.getGoodsDescription())
                .img1(goodsDTO.getGoodsImg1())
                .img2(goodsDTO.getGoodsImg2())
                .regTime(goodsDTO.getGoodsRegTime())
                .seller(seller)
                .stock(stock)
                .build();

        Goods result = goodsRepository.save(goods);

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
    }

    public void goodsUpdate(KMSGoodsDTO goodsDTO) throws Exception {
        Optional<Goods> result = goodsRepository.findById(goodsDTO.getGoodsNo());
        if(result.isEmpty())
            return;
        Goods goods = result.get();
        Stock stock = goods.getStock();
        stock.setQuantity(goodsDTO.getGoodsStock());

        goods.setName(goodsDTO.getGoodsName());
        goods.setPrice(goodsDTO.getGoodsPrice());
        goods.setDescription(goods.getDescription());
        goods.setImg1(goods.getImg1());
        goods.setImg2(goods.getImg2());
        goods.setStock(stock);

        Goods fixGoods = goodsRepository.save(goods);
        KMSGoodsResponseDTO responseDTO = KMSGoodsResponseDTO.goodsResponseDTOFactory(fixGoods);

        webClient.put().uri("/shopping/goods")
                .bodyValue(responseDTO)
                .header("sender","fulfilment1")
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public void goodsDelete(Long goodsNo) {
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

    public Goods findByGoodsCode(Long goodsCode) throws Exception {
        Optional<Goods> result = goodsRepository.findByCode(goodsCode);
        if(result.isEmpty())
            return null;
        return result.get();
    }
}
