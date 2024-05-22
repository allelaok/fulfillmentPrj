package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.GoodsDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.data.repository.GoodsRepository;

@Service
public class GoodsService {
	@Autowired
	private GoodsRepository goodsRepository;

	public GoodsDTO getGoods(Long goodsId) throws NoSuchElementException {
		Goods goods = this.goodsRepository.findById(goodsId).orElseThrow();
		GoodsDTO goodsDTO = new GoodsDTO();
		goodsDTO.fromGoods(goods);
		return goodsDTO;

	}

//	public List<GoodsDTO> getGoodsList(String seller) {
//		List<Goods> goodsList = goodsRepository.findBySellerId(seller);
//		List<GoodsDTO> goodsDTOList = new ArrayList<>();
//		for (Goods goods : goodsList) {
//			GoodsDTO goodsDTO = new GoodsDTO();
//			goodsDTO.fromGoods(goods);
//			goodsDTOList.add(goodsDTO);
//		}
//		return goodsDTOList;
//	}


	public void addGoods(GoodsDTO goodsDTO) {
		Goods goods = Goods.builder()
				.id(goodsDTO.getId())
				.name(goodsDTO.getName())
				.price(goodsDTO.getPrice())
				.seller(goodsDTO.getSeller()) // Seller 정보 설정
				.build();
		// 상품 등록
		this.goodsRepository.save(goods);
	}

	public void updateGoods(GoodsDTO goodsDTO) throws NoSuchElementException {
		Goods goods = this.goodsRepository.findById(goodsDTO.getId()).orElseThrow();
		goods = goodsDTO.fill(goods);
		this.goodsRepository.save(goods);
	}

	public void deleteGoods(Long goodsId) {
		// 상품 삭제
		goodsRepository.deleteById(goodsId);
	}
	

}
