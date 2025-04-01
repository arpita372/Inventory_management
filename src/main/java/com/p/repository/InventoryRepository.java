package com.p.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p.entity.Product;

public interface InventoryRepository extends JpaRepository<Product, Integer>{

}
