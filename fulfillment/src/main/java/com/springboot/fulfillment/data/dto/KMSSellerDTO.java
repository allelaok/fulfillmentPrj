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
public class KMSSellerDTO {

    private Long no;

    private String sellerId;

    private String password;

    private String name;

    private String contact;

    private String email;

    private String company;

    private Date regDate;

    private String shop;

}
