package com.springboot.fulfillment.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "delivery")
public class Delivery {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_no")
    private Long no;

    @Column(name = "d_delivery_id", nullable = false)
    private String dDeliveryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_order_id")
    private Orders order;

    @Column(name = "delivery_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "delivery_status", nullable = false)
    private Integer status;
}
