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
public class KMSGoodsDTO {
    private String sellerId;

    private Long goodsNo;
    private Long goodsCode;
    private String goodsName;
    private Integer goodsPrice;
    private String goodsDescription;
    private Long goodsStock;
    private String goodsImg1;
    private String goodsImg2;

}
