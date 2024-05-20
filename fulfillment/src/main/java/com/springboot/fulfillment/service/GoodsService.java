package com.springboot.fulfillment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.repository.GoodsRepository;

@Service
public class GoodsService {
	 @Autowired
	    private GoodsRepository goodsRepository;

	    public Goods getGoods(String goodsId) {
	        // 상품정보 가져오기
	        return goodsRepository.findById(goodsId).orElse(null);
	    }

	    public List<Goods> getGoodsList() {
	        // 상품 목록 가져오기
	        return goodsRepository.findAll();
	    }

	    public void addGoods(Goods goods) {
	        // 상품 등록
	        goodsRepository.save(goods);
	    }

	    public void updateGoods(Goods goods) {
	        // 상품 정보 수정
	        goodsRepository.save(goods);
	    }

	    public void deleteGoods(String goodsId) {
	        // 상품 삭제
	        goodsRepository.deleteById(goodsId);
	    }
}
