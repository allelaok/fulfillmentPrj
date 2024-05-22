package com.springboot.fulfillment.data.dto;

import java.util.Date;

import com.springboot.fulfillment.data.entity.Goods;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PurchaseDTO {
private Long no;
    
    private String purchaseId;

    private Integer quantity;

    private Date purchaseDate;

    private Integer purchaseStatus;
    
    private Goods goods;
}
