package com.ecomm.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Dto.CartDto;
import com.ecomm.Dto.OrderDto;
import com.ecomm.Entity.Cart;
import com.ecomm.Entity.Orders;
import com.ecomm.Service.CartService;
import com.ecomm.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDto addCart(CartDto cartDto) {
		
		Cart cart = new Cart();
		cart.setId(cartDto.getId());
		cart.setName(cartDto.getName());
		cart.setColor(cartDto.getColor());
		cart.setCategory(cartDto.getCategory());
		cart.setDescription(cartDto.getDescription());
		cart.setImage(cartDto.getImage());
		cart.setPrice(cartDto.getPrice());
		cart.setProductId(cartDto.getProductId());
		cart.setQuantity(cartDto.getQuantity());
		cart.setUserId(cartDto.getUserId());
		Cart save = cartRepository.save(cart);

		CartDto DTO2 = new CartDto();
		DTO2.setId(save.getId());
		DTO2.setName(save.getName());
		DTO2.setColor(save.getColor());
		DTO2.setCategory(save.getCategory());
		DTO2.setDescription(save.getDescription());
		DTO2.setImage(save.getImage());
		DTO2.setPrice(save.getPrice());
		DTO2.setProductId(save.getProductId());
		DTO2.setQuantity(save.getQuantity());
		DTO2.setUserId(save.getUserId());
		return DTO2;
	}

	@Override
	public CartDto getCartById(Long id) {
	
			 Optional<Cart> findById = cartRepository.findById(id);
			 CartDto dto = new CartDto();
			dto.setId(findById.get().getId());
			dto.setId(findById.get().getId());
			dto.setName(findById.get().getName());
			dto.setColor(findById.get().getColor());
			dto.setCategory(findById.get().getCategory());
			dto.setDescription(findById.get().getDescription());
			dto.setImage(findById.get().getImage());
			dto.setPrice(findById.get().getPrice());
			dto.setQuantity(findById.get().getQuantity());
			dto.setProductId(findById.get().getProductId());
			dto.setUserId(findById.get().getUserId());
			return dto;
		}

	@Override
	public void deleteCart(Long id) {
		cartRepository.deleteById(id);
		
	}

	@Override
	public List<CartDto> getCartByUserId(Long userId) {
			 List<Cart> findByUserId = cartRepository.findByUserId(userId);
			 List<CartDto> list = new ArrayList<>();
			 for (Cart cart : findByUserId) {
				 CartDto cartDto = new CartDto();
				 cartDto.setId(cart.getId());
				 cartDto.setName(cart.getName());
				 cartDto.setColor(cart.getColor());
				 cartDto.setCategory(cart.getCategory());
				 cartDto.setDescription(cart.getDescription());
				 cartDto.setImage(cart.getImage());
				 cartDto.setPrice(cart.getPrice());
				 cartDto.setQuantity(cart.getQuantity());
				 cartDto.setProductId(cart.getProductId());
				 cartDto.setUserId(cart.getUserId());
				 
				 list.add(cartDto);
				// return list;
			}

			return list;
		}

	@Override
	public List<CartDto> getAllCarts() {
		List<CartDto> cartDtos = new ArrayList<>();
		List<Cart> allData = cartRepository.findAll();
		for (Cart cart : allData) {
			CartDto cartDto1 = new CartDto();
			
		
			cartDto1.setId(cart.getId());
			cartDto1.setName(cart.getName());
			cartDto1.setColor(cart.getColor());
			cartDto1.setCategory(cart.getCategory());
			 cartDto1.setDescription(cart.getDescription());
			 cartDto1.setImage(cart.getImage());
			 cartDto1.setPrice(cart.getPrice());
			 cartDto1.setQuantity(cart.getQuantity());
			 cartDto1.setProductId(cart.getProductId());
			 cartDto1.setUserId(cart.getUserId());
			 cartDtos.add(cartDto1);
		}
		return cartDtos;
	}
	}

	

	

