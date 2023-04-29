package com.example.shoppingcart.services;

import java.util.List;
import java.util.Optional;

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
	
	public Product searchProductById(int id)
	{
		Optional<Product> productOptional = productrepository.findById(id);
		
		if(productOptional.isPresent())
		{
			return productOptional.get();
		}
		else
		{
			System.out.print("Product not found");
			return null;
		}
		
	}

	
	public List<Product> searchProductByName(String productName)

	{
		List<Product> productListOfNames = productrepository.findByProductName(productName);
		
		if(!productListOfNames.isEmpty())
		{
			return productListOfNames;
		}
		else
		{
			System.out.println("No Product found by" + productName);
			return null;
		}
		
	}
	
	public List<Product> searchProductByCategory(String Type)
	{
		List<Product> productListOfCategory = productrepository.findBymyDType(Type);
		
		if(!productListOfCategory.isEmpty())
		{
			return productListOfCategory;
		}
		else
		{
			System.out.println("No Product found by" + Type);
			return null;
		}
		
	}
	

}
