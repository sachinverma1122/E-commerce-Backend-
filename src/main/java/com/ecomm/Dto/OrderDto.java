package com.ecomm.Dto;

import lombok.Data;

@Data
public class OrderDto {

	private Long id;
	private String email;
	private String address;
	private double totalPrice;
	private Integer quantity;
	private Long userId;
}
