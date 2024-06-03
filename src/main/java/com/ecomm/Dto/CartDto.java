package com.ecomm.Dto;

import com.ecomm.Entity.User;

import lombok.Data;

@Data
public class CartDto {

	private Long id;
	private String name;
	private String price;
	private String category;
	private String description;
	private String image;
	private String color;
	private Integer quantity;
	private Integer userId;
	private Integer productId;
}
