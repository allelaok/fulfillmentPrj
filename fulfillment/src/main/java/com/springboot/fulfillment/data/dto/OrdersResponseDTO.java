package com.springboot.fulfillment.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersResponseDTO {
    private String customerName;
    private String customerContact;
    private Long customerZipCode;
    private String customerStreetAddress;
    private String customerDetailAddress;

    private Long goodsId;
    private Long orderStock;
    private Long orderStatus;
    private Long orderPrice;
}
