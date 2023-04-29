package com.example.shoppingcart.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	List<Product> findByProductName(String productName);
	
	@Query("SELECT p FROM Product p WHERE p.myDType =?1")
	List<Product> findBymyDType(String Dtype);

}
