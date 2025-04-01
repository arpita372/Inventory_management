package com.p.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.p.entity.Order;
import com.p.entity.Product;
import com.p.handler.InventoryHandler;
import com.p.handler.OrderHandler;

@Service
public class OrderProcessingService {
	
	private final OrderHandler orderHandler;
	private final InventoryHandler inventoryHandler;
	
	public OrderProcessingService(OrderHandler orderHandler, InventoryHandler inventoryHandler) {
		this.orderHandler = orderHandler;
		this.inventoryHandler = inventoryHandler;
	}
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
	 public Order placeAnOrder(Order order) {
		 
		 //get product inventory
		 System.out.println(order.getProductId());
		 Product product=inventoryHandler.getProduct(order.getProductId());
		 validateStockAvailability(order, product);
		 order.setTotalPrice(product.getPrice()*order.getQuantity());
		 Order saveOrder=orderHandler.saveOrder(order);
		 updateInventoryStock(order, product);
		 return saveOrder;
	 }

	private void validateStockAvailability(Order order, Product product) {
		if(product.getStockQuantity()<order.getQuantity()) {
			 throw new RuntimeException("Insufficient stock");
		 }
	}

	private void updateInventoryStock(Order order, Product product) {
		product.setStockQuantity(product.getStockQuantity()-order.getQuantity());
		 inventoryHandler.updateProductDetails(product);
	}
}
