package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KMSStockDTO {
    private Long no;
    private Long wStockId;
    private Integer quantity;
    private Date regDate;
    private Long sellerNo;
    private Long storageNo;

    private KMSStockDTO fromStock(Stock stock) {
        this.no = stock.getNo();
        this.wStockId = stock.getWStockId();
        this.quantity = stock.getQuantity();
        this.regDate = new Date(stock.getRegDate().getTime());
        this.sellerNo = stock.getSeller().getNo();
        this.storageNo = stock.getStorage().getNo();
        return this;
    }

    public static KMSStockDTO stockFactory(Stock stock) {
        KMSStockDTO kmsStockDTO = new KMSStockDTO();
        kmsStockDTO.fromStock(stock);
        return kmsStockDTO;
    }
}
