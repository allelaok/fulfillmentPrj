package com.springboot.fulfillment.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springboot.fulfillment.data.dto.GoodsCreateDTO;
import com.springboot.fulfillment.data.dto.GoodsListResponseDTO;
import com.springboot.fulfillment.data.dto.GoodsReadResponseDTO;
import com.springboot.fulfillment.service.GoodsService;

import io.swagger.annotations.ApiOperation;

@Controller
public class GoodsController {

	// 세션에서 판매자 아이디 가져오기
	private String sellerId = "lasolim";
	
    @Autowired
    private GoodsService goodsService;

    @GetMapping("goods/read/{goodsId}")
    public String getGoods(@PathVariable("goodsId") String goodsId, Model model) {
        try {
            GoodsReadResponseDTO goodsReadResponseDTO = this.goodsService.getGoods(goodsId);
            model.addAttribute("goodsReadResponseDTO", goodsReadResponseDTO);
            return "goodsRead";
        } catch (NoSuchElementException ex) {
        	return "home";
            // 에러 처리
//            return "errorPage"; // 에러 페이지로 리다이렉트 또는 에러 처리 로직 추가
        }
    }

    @GetMapping("/goods/list")
    public String getGoodsList(Model model) {
        List<GoodsListResponseDTO> goodsList = goodsService.getGoodsList(sellerId);
        model.addAttribute("goodsList", goodsList);
        return "goodsList";
    }
	
    
	@GetMapping("/goods/create")
	public String create() {
		return "goodsCreate";
	}

    @ApiOperation(value = "Add a new goods")
    @PostMapping("/goods/create")
    public String addGoods(GoodsCreateDTO goodsCreateDTO) {
    	goodsCreateDTO.setSellerId(sellerId);
        goodsService.addGoods(goodsCreateDTO);
		return "home";
    }
    
	@GetMapping("/goods/update")
	public String update() {
		return "goodsUpdate";
	}

    @PutMapping("/goods/update")
    public String updateGoods(GoodsCreateDTO goodsCreateDTO) {
    	goodsService.addGoods(goodsCreateDTO);
		return "home";
    }

    @DeleteMapping("goods/delete/{goodsId}")
    public void deleteGoods(@PathVariable("goodsId") String goodsId) {
        goodsService.deleteGoods(goodsId);
    }
}
