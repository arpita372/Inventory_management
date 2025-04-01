package com.p.handler;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.p.entity.Product;
import com.p.repository.InventoryRepository;

@Service
public class InventoryHandler {
	
	private final InventoryRepository inventoryRepository;

	public InventoryHandler(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	@CachePut(value="product",key="#product.id")
	public Product updateProductDetails(Product product) {
		return inventoryRepository.save(product);
		
	}
	
	@Cacheable(value="product",key="#id")
	public Product getProduct(int id) {
		return inventoryRepository.findById(id)
				.orElseThrow(
						()-> new RuntimeException("Product not found")  
					);
	}
	
	@CacheEvict(value="product",key="#id")
	public void deleteProduct(int id) {
		 inventoryRepository.deleteById(id);
	}
	
}
