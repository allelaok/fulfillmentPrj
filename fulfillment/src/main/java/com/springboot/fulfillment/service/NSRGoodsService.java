package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.GoodsDTO;
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
		// 판매자 아이디로 판매자 가져오기
		System.out.println("아이디 가져오기");
	    Seller seller = sellerRepository.findBySellerIdContains(sellerId);
	    System.out.println(seller.getName());
	    Stock stock = stockService.createStockAuto(sellerId);
	    Goods newGoods = Goods.builder()
                .name(goodsDTO.getName())
                .img1(goodsDTO.getImg1())
                .code(goodsDTO.getCode())
                .description(goodsDTO.getDescription())
                .price(goodsDTO.getPrice())
                .seller(seller)
                .stock(stock)
                .build();

		System.out.println("엔티티 빌더 완료");
	    // Save the new goods
	    Goods savedGoods = goodsRepository.save(newGoods);

		System.out.println("상품 저장");
		GoodsDTO savedGoodsDTO = GoodsDTO.GoodsFactory(savedGoods);
		
	    return savedGoodsDTO;
	}

	public GoodsDTO getGoods(Long no) {
		Goods goods = goodsRepository.getById(no);

		GoodsDTO getGoodsDTO = GoodsDTO.GoodsFactory(goods);
		
		return getGoodsDTO;
	}
	
	public GoodsDTO updateGoods(GoodsDTO goodsDTO) {

			    Goods newGoods = Goods.builder()
		                .name(goodsDTO.getName())
		                .img1(goodsDTO.getImg1())
		                .code(goodsDTO.getCode())
		                .description(goodsDTO.getDescription())
		                .price(goodsDTO.getPrice())
		                .build();

				System.out.println("엔티티 빌더 완료");
			    // Save the new goods
			    Goods savedGoods = goodsRepository.save(newGoods);
				System.out.println("상품 저장");

				GoodsDTO savedGoodsDTO = GoodsDTO.GoodsFactory(savedGoods);
			    return savedGoodsDTO;
	}
}
