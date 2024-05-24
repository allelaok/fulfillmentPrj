package com.springboot.fulfillment.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	Long sellerNo = 1L;
	
	@Autowired
	private NSRGoodsService goodsService;
	

	@RequestMapping({"/list"})
	public ModelAndView getGoodsList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("goods/list"); // 뷰의 이름 설정
		List<GoodsDTO> goodsList = goodsService.getGoodsList(sellerNo);
		modelAndView.addObject("goodsList", goodsList);
		
		// 보내기
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
            @RequestParam("goodsImg1") MultipartFile goodsImg1,
            @RequestParam(value = "goodsImg2", required = false) MultipartFile goodsImg2) {
		System.out.println("여기보세요~~~~");
		
		String path1 = uploadFile(goodsImg1);
		String path2 = "";
		if(goodsImg2 != null)
			path2 = uploadFile(goodsImg2);
				
		if(path1 == "fail" || path2 == "fail") {
		      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                           .body("이미지 저장에 실패했습니다.");
		}
		
        // 이미지 경로 설정
        goodsDTO.setGoodsImg1(path1);
        goodsDTO.setGoodsImg2(path2);

        // DB에 데이터 저장
         goodsService.createGoods(sellerId, goodsDTO);
         
        return ResponseEntity.ok("상품 등록이 완료되었습니다.");
    }
	
	String uploadFile(MultipartFile img) {
        // 이미지 저장 경로 설정
		String projectPath = "C:/Users/gladius/git/fulfillmentPrj/fulfillment/src/main/resources/static";
	    String uploadDir = "/images/";
//		String uploadDir = "C:\\fulfillmentImgs\\";
        String fileName = img.getOriginalFilename();
        String filePath = projectPath + uploadDir + fileName;

        try {
            // 이미지 파일 저장
            File uploadFile = new File(filePath);
            img.transferTo(uploadFile);
            
            return uploadDir + fileName;
        } catch (IOException e) {
        	return "fail";
        }
	}
	
	@GetMapping("/updatePage/{no}")
	public ModelAndView updateGoodsPage(@PathVariable("no") Long no) {
		
		ModelAndView modelAndView = new ModelAndView();
		GoodsDTO goodsDTO = goodsService.getGoods(no);
		modelAndView.addObject("goods", goodsDTO);
		modelAndView.setViewName("goods/update");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateGoods(
			@RequestPart("data") GoodsDTO goodsDTO,
            @RequestParam(value = "goodsImg1", required = false) MultipartFile goodsImg1,
            @RequestParam(value = "goodsImg2", required = false) MultipartFile goodsImg2) {
		
		String path1 = "";
		if(goodsImg2 != null)
			path1 = uploadFile(goodsImg1);
		String path2 = "";
		if(goodsImg2 != null)
			path2 = uploadFile(goodsImg2);
				
		if(path1 == "fail" || path2 == "fail") {
		      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                           .body("이미지 저장에 실패했습니다.");
		}
		
        // 이미지 경로 설정
        goodsDTO.setGoodsImg1(path1);
        goodsDTO.setGoodsImg2(path2);
        
		goodsService.updateGoods(goodsDTO);
		
		return ResponseEntity.ok("상품 등록이 완료되었습니다.");
	}
	

	@GetMapping("/delete/{no}")
	public ModelAndView deleteGoods(@PathVariable("no") Long no) {
				
		ModelAndView modelAndView = new ModelAndView();
		goodsService.deleteGoods(no);
		modelAndView.setViewName("redirect:/goods/list");		
		return modelAndView;
	}
	
//	@PostMapping("/updatePage")
//    public ResponseEntity<String> updateGoodsPage(
//            @RequestPart("data") GoodsDTO goodsDTO,
//            @RequestParam("img1") MultipartFile img1,
//            @RequestParam(value = "img2", required = false) MultipartFile img2) {
//		
//        // DB에 데이터 저장
//         goodsService.updateGoods(goodsDTO);
//        
//        return ResponseEntity.ok("상품 등록이 완료되었습니다.");
//    }

}
