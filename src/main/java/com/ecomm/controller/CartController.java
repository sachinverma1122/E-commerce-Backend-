package com.ecomm.controller;

import java.util.List;

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
import com.ecomm.Service.impl.CartServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cart")
public class CartController {

	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@PostMapping
	public ResponseEntity<CartDto> addProduct(@RequestBody CartDto cartDto) {
		// Product product = convertToEntity(productDTO);
		CartDto addCartDto = cartServiceImpl.addCart(cartDto);
		return new ResponseEntity<CartDto>(addCartDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long cartId) {
		  CartDto cartById = cartServiceImpl.getCartById(cartId);
		if (cartById !=null) {
			cartServiceImpl.deleteCart(cartId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<List<CartDto>> getCartByUserId(@RequestParam Long userId) {
		 List<CartDto> cartByUserId = cartServiceImpl.getCartByUserId(userId);
		 return new ResponseEntity<List<CartDto>>(cartByUserId, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public List<CartDto> getAllCarts() {
		return cartServiceImpl.getAllCarts();
	}
}



