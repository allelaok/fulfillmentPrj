package com.springboot.fulfillment.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KMSGoodsDTO {

    private Long goodsNo;
    private Long goodsCode;
    private String goodsName;
    private Integer goodsPrice;
    private String goodsDescription;
    private Integer goodsStock;
    private String goodsImg1;
    private String goodsImg2;
    private Date goodsRegTime;

    private Long sellerNo;
    private String sellerId;
    private String sellerPassword;
    private String sellerName;
    private String sellerContact;
    private String sellerEmail;
    private String sellerCompany;
    private Date sellerRegDate;
    private String sellerShop;

    private Long stockNo;
    private Long wStockId;
    private Integer stockQuantity;
    private Date stockRegDate;
    private Long storageNo;
}
