package com.springboot.fulfillment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.dto.GoodsCreateDTO;
import com.springboot.fulfillment.data.dto.GoodsListResponseDTO;
import com.springboot.fulfillment.data.dto.GoodsReadResponseDTO;
import com.springboot.fulfillment.data.dto.GoodsUpdateDTO;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.repository.GoodsRepository;

@Service
public class GoodsService {
	 @Autowired
	    private GoodsRepository goodsRepository;

	    public GoodsReadResponseDTO getGoods(String goodsId)
	    		throws NoSuchElementException {
	    	Goods goods = this.goodsRepository.findById(goodsId).orElseThrow();
	    	GoodsReadResponseDTO goodsReadResponseDTO = new GoodsReadResponseDTO();
			goodsReadResponseDTO.fromGoods(goods);
			return goodsReadResponseDTO;
	    	
	    }

	    public List<GoodsListResponseDTO> getGoodsList(String sellerId) {
	    	 List<Goods> goodsList = goodsRepository.findBySellerId(sellerId);
	        List<GoodsListResponseDTO> goodsDTOList = new ArrayList<>();
	        for (Goods goods : goodsList) {
	        	GoodsListResponseDTO goodsDTO = new GoodsListResponseDTO();
	            goodsDTO.fromGoods(goods);
	            goodsDTOList.add(goodsDTO);
	        }
	        return goodsDTOList;
	    }

	    public void addGoods(GoodsCreateDTO goodsCerateDTO) {
	    	
	    	Goods goods = Goods.builder()
					.goodsId(goodsCerateDTO.getGoodsId())
					.goodsName(goodsCerateDTO.getGoodsName())
					.goodsPrice(goodsCerateDTO.getGoodsPrice())
					.build();
	    	// 상품 등록
			this.goodsRepository.save(goods);
	    }

		public void updateGoods(GoodsUpdateDTO goodsUpdateDTO) throws NoSuchElementException{
			Goods goods = this.goodsRepository.findById(goodsUpdateDTO.getGoodsId()).orElseThrow();
			goods = goodsUpdateDTO.fill(goods);
			this.goodsRepository.save(goods);
		}
		


		   public void deleteGoods(String goodsId) {
		        // 상품 삭제
		        goodsRepository.deleteById(goodsId);
		    }
}
