package com.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p.entity.Order;
import com.p.entity.Product;
import com.p.handler.InventoryHandler;
import com.p.service.OrderProcessingService;

@RestController
@RequestMapping("/api/v1/")
public class OrderProcessingController {

	private final OrderProcessingService orderProcessingService;

	public OrderProcessingController(OrderProcessingService orderProcessingService) {
		this.orderProcessingService = orderProcessingService;
	}
	
	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody Order order) {
		return ResponseEntity.ok(orderProcessingService.placeAnOrder(order));
	}
	
	
}
