package com.ecomm.Service;

import java.util.List;

import com.ecomm.Dto.CartDto;
import com.ecomm.Dto.OrderDto;

public interface OrderService{
	
	public OrderDto createOrder(OrderDto dto);
	public OrderDto getOrderById(Long orderId);
	public void deleteOrder(Long id);
	public List<OrderDto> getOrderByUserId(Long userId);
}
