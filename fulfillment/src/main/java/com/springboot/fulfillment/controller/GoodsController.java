package com.springboot.fulfillment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springboot.fulfillment.data.dto.GoodsDTO;
import com.springboot.fulfillment.data.dto.SellerDTO;
import com.springboot.fulfillment.data.entity.Seller;
import com.springboot.fulfillment.service.GoodsService;
import com.springboot.fulfillment.service.SellerService;

import io.swagger.annotations.ApiOperation;

@Controller
public class GoodsController {

	// 세션에서 판매자 아이디 가져오기
	private String sellerId = "lasolim";
	
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SellerService sellerService;

	@GetMapping("/goods/create")
	public String create() {
		return "goods/create";
	}

    @ApiOperation(value = "Add a new goods")
    @PostMapping("/goods/create")
    public String addGoods(GoodsDTO goodsDTO) {
    	
    	Seller seller = sellerService.getSeller(goodsDTO.getSellerId());
    	
    	goodsDTO.setSeller(seller);
    	
        goodsService.addGoods(goodsDTO);
		return "goods/list";
    }
    
//    @GetMapping("/goods/list")
//    public String getGoodsList(Model model) {
//    	
////    	Seller seller = sellerService.getSeller(sellerId);
//    	
//        List<GoodsDTO> goodsList = goodsService.getGoodsList(sellerId);
//        model.addAttribute("goodsList", goodsList);
//        return "goods/list";
//    }
//	
    
//
//    @GetMapping("goods/read/{goodsId}")
//    public void getGoods(@PathVariable("goodsId") Integer goodsId, Model model) {
//        try {
//            GoodsReadResponseDTO goodsReadResponseDTO = this.goodsService.getGoods(goodsId);
//            model.addAttribute("goodsReadResponseDTO", goodsReadResponseDTO);
////            return "goods/read";
//        } catch (NoSuchElementException ex) {
////        	return "list";
//            // 에러 처리
////            return "errorPage"; // 에러 페이지로 리다이렉트 또는 에러 처리 로직 추가
//        }
//    }

    
    
	@GetMapping("/goods/update")
	public String update() {
		return "goods/update";
	}

    @PutMapping("/goods/update")
    public String updateGoods(GoodsDTO goodsDTO) {
    	goodsService.updateGoods(goodsDTO);
		return "goods/list";
    }

    @DeleteMapping("/goods/delete/{goodsId}")
    public String deleteGoods(@PathVariable("goodsId") Long goodsId) {
        goodsService.deleteGoods(goodsId);
        return "goods/list";
    }
    

    @GetMapping("/addSeller")
    public String addSeller(SellerDTO sellerDTO) {
    	sellerDTO.setSellerId("lasolim");
    	sellerDTO.setContact("010-2997-2975");
    	sellerService.addSeller(sellerDTO);
        return "goods/list";
    }
    
    

    @GetMapping("/getSeller")
    public String getSeller(SellerDTO sellerDTO) {
    	sellerDTO.setContact("010-2997-2975");
    	sellerService.getSellerIdByContact(sellerDTO);
        return "goods/list";
    }
}
