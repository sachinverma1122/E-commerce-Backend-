package com.ecomm.Service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Dto.CartDto;
import com.ecomm.Dto.OrderDto;
import com.ecomm.Dto.ProductDTO;
import com.ecomm.Entity.Orders;
import com.ecomm.Entity.Product;
import com.ecomm.Service.OrderService;
import com.ecomm.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public OrderDto createOrder(OrderDto dto) {
		
		Orders order = new Orders();
		order.setId(dto.getId());
		order.setEmail(dto.getEmail());
		order.setAddress(dto.getAddress());
		order.setTotalPrice(dto.getTotalPrice());
		order.setUserId(dto.getUserId());
		order.setQuantity(dto.getQuantity());
		Orders save = orderRepository.save(order);
		
		OrderDto dto2 = new OrderDto();
		dto2.setId(save.getId());
		dto2.setEmail(save.getEmail());
		dto2.setAddress(save.getAddress());
		dto2.setTotalPrice(save.getTotalPrice());
		dto2.setUserId(save.getUserId());
		dto2.setQuantity(save.getQuantity());
		return dto2;
	}


	@Override
	public OrderDto getOrderById(Long orderId) {
		Optional<Orders> findById = orderRepository.findById(orderId);
		OrderDto dto = new OrderDto();
		dto.setId(findById.get().getId());
		dto.setEmail(findById.get().getEmail());
		dto.setAddress(findById.get().getAddress());
		dto.setTotalPrice(findById.get().getTotalPrice());
		dto.setUserId(findById.get().getUserId());
		dto.setQuantity(findById.get().getQuantity());
		return dto;
	}


	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
		
	}


	@Override
	public List<OrderDto> getOrderByUserId(Long userId) {
		List<OrderDto> dtos = new ArrayList<>();
		List<Orders> findByUserId = orderRepository.findByUserId(userId);
		for (Orders orders : findByUserId) {
			OrderDto orderDto = new OrderDto();
			orderDto.setId(orders.getId());
			orderDto.setEmail(orders.getEmail());
			orderDto.setAddress(orders.getAddress());
			orderDto.setTotalPrice(orders.getTotalPrice());
			orderDto.setUserId(orders.getUserId());
			orderDto.setQuantity(orders.getQuantity());
					dtos.add(orderDto);
		}
		
		return dtos;
	}

}
