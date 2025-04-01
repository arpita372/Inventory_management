package com.p.handler;

import org.springframework.stereotype.Service;

import com.p.entity.Order;
import com.p.repository.OrderRepository;

@Service
public class OrderHandler {

	private final OrderRepository orderRepository;

	public OrderHandler(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	} 
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
}
