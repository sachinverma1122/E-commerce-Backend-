package com.ecomm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Dto.CartDto;
import com.ecomm.Dto.OrderDto;
import com.ecomm.Dto.ProductDTO;
import com.ecomm.Service.impl.OrderServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/order")
public class OrderController {

	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping
	public ResponseEntity<OrderDto> createOrders(@RequestBody OrderDto OrderDto) {
		// Product product = convertToEntity(productDTO);
		OrderDto Dto = orderServiceImpl.createOrder(OrderDto);
		return new ResponseEntity<OrderDto>(Dto, HttpStatus.CREATED);
	}
	

	@GetMapping
	public ResponseEntity<List<OrderDto>> getOrderByUserId(@RequestParam Long userId) {
		 List<OrderDto> orderByUserId = orderServiceImpl.getOrderByUserId(userId);
		 return new ResponseEntity<List<OrderDto>>(orderByUserId, HttpStatus.CREATED);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
		 OrderDto orderById = orderServiceImpl.getOrderById(orderId);
		if (orderById !=null) {
			orderServiceImpl.deleteOrder(orderId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}
}