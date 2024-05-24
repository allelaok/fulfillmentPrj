package com.springboot.fulfillment.controller;

import com.springboot.fulfillment.data.dto.StockResponseDTO;
import com.springboot.fulfillment.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // 재고 첫 등록
    @PostMapping
    public ResponseEntity<String> addStock(@RequestBody StockResponseDTO stockDTO) {
        stockService.addStock(stockDTO);
        return ResponseEntity.ok("Stock added successfully");
    }

    //    // 재고 수정 (입고, 출고 포함)
//    @PutMapping
//    public ResponseEntity<String> updateStock(@RequestBody StockResponseDTO stockDTO) {
//        stockService.updateStock(stockDTO);
//        return ResponseEntity.ok("Stock updated successfully");
//    }
    @PutMapping()
    public ResponseEntity<StockResponseDTO> updateStock(@PathVariable Long id, @RequestBody StockResponseDTO stockResponseDTO) {
        stockResponseDTO.setNo(id); // Ensure ID is set
        StockResponseDTO updatedStock = stockService.updateStock(stockResponseDTO);
        return ResponseEntity.ok(updatedStock);
    }

    // 재고 삭제
    @DeleteMapping("/{stockId}")
    public ResponseEntity<String> deleteStock(@PathVariable Long stockId) {
        stockService.deleteStock(stockId);
        return ResponseEntity.ok("Stock deleted successfully");
    }

    // 재고 조회
    @GetMapping("/{stockId}")
    public ResponseEntity<StockResponseDTO> getStockById(@PathVariable Long stockId) {
        StockResponseDTO stockDTO = stockService.getStockById(stockId);
        return ResponseEntity.ok(stockDTO);
    }

}
