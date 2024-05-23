package com.springboot.fulfillment.data.dto;

import java.util.Date;

import com.springboot.fulfillment.data.entity.Customer;
import com.springboot.fulfillment.data.entity.Goods;
import com.springboot.fulfillment.data.entity.Orders;

import com.springboot.fulfillment.data.entity.Stock;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {
	// 주문
	private Long no;
	private int quantity;
	private String orderId;
	private int orderPrice;
	private Date orderDate;
	private int status;

	// 구매자
	private Long customerNo;
	private String customerShId;
	private String customerName;
	private String customerContact;
	private int customerZipCode;
	private String customerStreetAddress;
	private String customerDetailAddress;
	// 판매 상품
	private Long goodsNo;
	private Long goodsCode;
	private String goodsName;
	private String goodsDescription;
	private String goodsImg1;
	// 재고
	private Long stockNo;
	private Integer stockQuantity;
	private String storageName;

	// 필요에 따라 메소드 추가
	private OrdersDTO fromOrder(Orders orders) {
		this.no = orders.getNo();
		this.quantity = orders.getQuantity();
		this.orderId = orders.getOrderId();
		this.status = orders.getStatus();
		this.customerNo = orders.getCustomer().getNo();
		this.customerShId = orders.getCustomer().getShId();
		this.customerName = orders.getCustomer().getName();
		this.customerContact = orders.getCustomer().getContact();
		this.customerZipCode = orders.getCustomer().getZipCode();
		this.customerStreetAddress = orders.getCustomer().getStreetAddress();
		this.customerDetailAddress = orders.getCustomer().getDetailAddress();
		this.goodsNo = orders.getGoods().getNo();
		this.goodsCode = orders.getGoods().getCode();
		this.goodsName = orders.getGoods().getName();
		this.orderPrice = orders.getPrice();
		this.goodsDescription = orders.getGoods().getDescription();
		this.goodsImg1 = orders.getGoods().getImg1();

		return this;
	}

	private OrdersDTO fromStock(OrdersDTO ordersDTO, Stock stock) {
		ordersDTO.setStockNo(stock.getNo());
		ordersDTO.setStockQuantity(stock.getQuantity());
		ordersDTO.setStorageName(stock.getStorage().getName());
		return ordersDTO;
	}

	public static OrdersDTO ordersDTOFactory(Orders orders, Stock stock) {
		OrdersDTO ordersDTO = new OrdersDTO();
		ordersDTO.fromOrder(orders);
		ordersDTO.fromStock(ordersDTO,stock);
		return ordersDTO;
	}

}
