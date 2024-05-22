package com.springboot.fulfillment.data.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name = "delivery_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "d_delivery_id")
	private String dDeliveryId;
    
    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    private Orders order;
    
	
	@ColumnDefault("0")
	@Column(name = "delivery_quantity")
	private Integer quantity;
	
	@Column(nullable = false, name = "delivery_status")
	private Integer status;
	
	// orders 쪽에서 여기로 FK 연결하고
}
