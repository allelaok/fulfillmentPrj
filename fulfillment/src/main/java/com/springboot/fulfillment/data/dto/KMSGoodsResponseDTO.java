package com.springboot.fulfillment.data.dto;

import com.springboot.fulfillment.data.entity.Goods;
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
public class KMSGoodsResponseDTO {
    private String sellerContact;

    private Long goodsCode;
    private String goodsName;
    private Long goodsPrice;
    private String goodsDescription;
    private Integer goodsStock;
    private String goodsImg1;
    private String goodsImg2;

    private KMSGoodsResponseDTO fromGoods(Goods goods) {
        this.sellerContact = goods.getSeller().getContact();
        this.goodsCode = goods.getCode();
        this.goodsName = goods.getName();
        this.goodsPrice = Long.valueOf(goods.getPrice());
        this.goodsDescription = goods.getDescription();
        this.goodsStock = goods.getStock().getQuantity();
        this.goodsImg1 = goods.getImg1();
        this.goodsImg2 = goods.getImg2();
        return this;
    }

    public static KMSGoodsResponseDTO goodsResponseDTOFactory(Goods goods) {
        KMSGoodsResponseDTO kmsGoodsResponseDTO = new KMSGoodsResponseDTO();
        kmsGoodsResponseDTO.fromGoods(goods);
        return kmsGoodsResponseDTO;
    }
}
