package com.springboot.fulfillment.data.dto;

import lombok.Data;

@Data
public class StockResponseDTO {

    private String wStockId; // 물류센터코드(header)_물류센터 창고 아이디
    private Integer quantity;

}
