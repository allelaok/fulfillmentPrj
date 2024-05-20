package com.springboot.fulfillment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.service.GoodsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


	
	@GetMapping("/goodsCreate")
	public String create() {
		return "goodsCreate";
	}
	
    @GetMapping("/{goodsId}")
    public Goods getGoods(@PathVariable String goodsId) {
        return goodsService.getGoods(goodsId);
    }

    @GetMapping
    public List<Goods> getGoodsList() {
        return goodsService.getGoodsList();
    }


    @ApiOperation(value = "Add a new goods")
    @PostMapping
    public void addGoods(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
    }

    @PutMapping("/{goodsId}")
    public void updateGoods(@PathVariable String goodsId, @RequestBody Goods goods) {
        // update logic
    }

    @DeleteMapping("/{goodsId}")
    public void deleteGoods(@PathVariable String goodsId) {
        goodsService.deleteGoods(goodsId);
    }
}
