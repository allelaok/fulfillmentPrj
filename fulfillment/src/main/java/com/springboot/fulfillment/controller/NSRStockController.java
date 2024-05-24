package com.springboot.fulfillment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.fulfillment.data.dto.GoodsDTO;
import com.springboot.fulfillment.service.NSRGoodsService;
import com.springboot.fulfillment.service.NSRStockService;

@RestController
@RequestMapping("/stocks")
public class NSRStockController {

	String sellerId = "seller1";
	Long sellerNo = 1L;
	
	@Autowired
	private NSRStockService sotckService;
	@Autowired
	private NSRGoodsService goodsService;
	

	@RequestMapping({"/list"})
	public ModelAndView getStockList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("stock/list"); // 뷰의 이름 설정
		List<GoodsDTO> goodsList = goodsService.getGoodsList(sellerNo);
		modelAndView.addObject("goodsList", goodsList);
		
		// 보내기
		return modelAndView;
	}
}
