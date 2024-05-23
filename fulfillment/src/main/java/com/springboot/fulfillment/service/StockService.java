package com.springboot.fulfillment.service;

import com.springboot.fulfillment.data.dto.StockResponseDTO;
import com.springboot.fulfillment.data.entity.Purchase;
import com.springboot.fulfillment.data.entity.Stock;
import com.springboot.fulfillment.data.repository.PurchaseRepository;
import com.springboot.fulfillment.data.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service("stockService")
public class StockService {

    private final StockRepository stockRepository;
    private final PurchaseRepository purchaseRepository;
    private final WebClient webClient;

    @Autowired
    public StockService(StockRepository stockRepository, PurchaseRepository purchaseRepository) {
        this.stockRepository = stockRepository;
        this.purchaseRepository = purchaseRepository;
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:9050") // 물류센터 서버의 URL로 설정
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void addStock(StockResponseDTO stockDTO) {
        // DTO를 엔티티로 변환하고 총 수량을 설정
        Stock stock = convertToEntity(stockDTO);
        stock.setQuantity(calculateTotalQuantity(stock.getWStockId())); // 총 수량 계산 및 설정

        // 엔티티를 데이터베이스에 저장
        stockRepository.save(stock);

        // 물류센터 프로젝트로 데이터 전송
        sendStockToWarehouse(stockDTO);
    }

    public void updateStock(StockResponseDTO stockDTO) {
        Long stockId = parseWStockId(stockDTO.getWStockId());
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        stock.setQuantity(calculateTotalQuantity(stockId));
        stockRepository.save(stock);

        // 물류센터 프로젝트로 데이터 전송
        sendStockToWarehouse(stockDTO);
    }

    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);
    }

    public StockResponseDTO getStockById(Long stockId) {
        Optional<Stock> stockOptional = stockRepository.findById(stockId);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            return convertToDTO(stock);
        } else {
            throw new RuntimeException("Stock not found");
        }
    }

    private Stock convertToEntity(StockResponseDTO stockDTO) {
        Stock stock = new Stock();
        stock.setWStockId(parseWStockId(stockDTO.getWStockId()));
        stock.setQuantity(calculateTotalQuantity(parseWStockId(stockDTO.getWStockId()))); // 총 수량 계산 및 설정
        return stock;
    }

    private StockResponseDTO convertToDTO(Stock stock) {
        StockResponseDTO stockDTO = new StockResponseDTO();
        stockDTO.setWStockId(formatWStockId(stock.getWStockId()));
        stockDTO.setQuantity(stock.getQuantity());
        return stockDTO;
    }

    private void sendStockToWarehouse(StockResponseDTO stockDTO) {
        // WebClient를 사용하여 물류센터 서버로 데이터 전송
        webClient.post()
                .uri("/products")
                .bodyValue(stockDTO)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    private Long parseWStockId(String wStockId) {
        // wStockId를 Long 타입으로 변환
        String[] parts = wStockId.split("_");
        return Long.parseLong(parts[1]);
    }

    private String formatWStockId(Long wStockId) {
        // Long 타입의 wStockId를 포맷된 String 타입으로 변환
        return "header_" + wStockId;
    }

    private Integer calculateTotalQuantity(Long stockId) {
        // Purchase 테이블에서 goods의 stockId와 관련된 모든 Purchase 엔티티의 quantity 값을 합산
        List<Purchase> purchases = purchaseRepository.findByGoodsStockNo(stockId);
        return purchases.stream()
                .mapToInt(Purchase::getQuantity)
                .sum();
    }
}
