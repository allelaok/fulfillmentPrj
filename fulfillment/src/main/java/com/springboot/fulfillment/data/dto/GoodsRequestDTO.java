package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Goods;
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
public class GoodsRequestDTO {
    private String sellerContact;

    private Long goodsId;
    private Long goodsCode;
    private String goodsName;
    private Long goodsPrice;
    private String goodsDescription;
    private Long goodsStock;
    private String goodsImg1;
    private String goodsImg2;
    private Date goodsRegDate;

}
