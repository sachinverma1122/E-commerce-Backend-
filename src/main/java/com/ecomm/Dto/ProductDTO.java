package com.ecomm.Dto;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private String name;
	private String price;
	private String category;
	private String description;
	private String image;
	private String color;
}
