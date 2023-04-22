package com.example.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepository;
	
	public String saveProduct(Product product)
	{
		
		System.out.print(product);
		productrepository.save(product);		
		return "Saved";
	}
	
	

}
