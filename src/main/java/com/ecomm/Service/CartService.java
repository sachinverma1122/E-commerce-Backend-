package com.ecomm.Service;

import java.util.List;

import com.ecomm.Dto.CartDto;
import com.ecomm.Dto.OrderDto;
import com.ecomm.Dto.ProductDTO;
import com.ecomm.Entity.Orders;

public interface CartService {

	public CartDto addCart(CartDto cartDto);

	public CartDto getCartById(Long id);

	public void deleteCart(Long id);
	 public List<CartDto> getAllCarts();

	public List<CartDto> getCartByUserId(Long userId);

}
