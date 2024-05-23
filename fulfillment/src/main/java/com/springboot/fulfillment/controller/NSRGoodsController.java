package com.springboot.fulfillment.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.fulfillment.data.dto.GoodsDTO;
import com.springboot.fulfillment.service.NSRGoodsService;

@RestController
@RequestMapping("/goods")
public class NSRGoodsController {

	String sellerId = "seller1";
	
	@Autowired
	private NSRGoodsService goodsService;

	@RequestMapping("/list")
	public ModelAndView getGoodsList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("goods/list"); // 뷰의 이름 설정
		List<GoodsDTO> goodsList = goodsService.getGoodsList(1L);
		modelAndView.addObject("goodsList", goodsList);
		return modelAndView;
	}

	@RequestMapping("/createPage")
	public ModelAndView createGoodsPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("goods/create"); // 뷰의 이름 설정
		return modelAndView;
	}

	@PostMapping("/create")
    public ResponseEntity<String> createGoods(
            @RequestPart("data") GoodsDTO goodsDTO,
            @RequestParam("img1") MultipartFile img1) {
        
		System.out.println(goodsDTO.getCode());
		
        // 이미지 저장 경로 설정
	    String uploadDir = "C:\\fulfillmentImgs\\";
        String fileName = img1.getOriginalFilename();
        String filePath = uploadDir + fileName;
        
        try {
            // 이미지 파일 저장
            File uploadFile = new File(filePath);
            img1.transferTo(uploadFile);
            
            // 이미지 경로 설정
            goodsDTO.setImg1(filePath);
            
            // DB에 데이터 저장
             goodsService.createGoods(sellerId, goodsDTO);
            
            return ResponseEntity.ok("상품 등록이 완료되었습니다.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("이미지 저장에 실패했습니다.");
        }
    }

}
