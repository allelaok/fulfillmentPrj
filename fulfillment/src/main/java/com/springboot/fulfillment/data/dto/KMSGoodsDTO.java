package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Orders;
import com.springboot.fulfillment.data.entity.Stock;
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
    private Long goodsPrice;
    private String goodsDescription;
    private Long goodsStock;
    private String goodsImg1;
    private String goodsImg2;

}
