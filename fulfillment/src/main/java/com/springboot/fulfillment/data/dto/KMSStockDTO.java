package com.springboot.fulfillment.data.dto;

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
    private Long wStockNo;

    private Integer quantity;

    private Date regdate;

    private String sellerNo;

    private Long storageNo;
}
