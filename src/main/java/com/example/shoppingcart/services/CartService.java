package com.example.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.ProductRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepo;
	
	public Cart addProductTocart(Cart cart)
	{
		List<Product> product = new ArrayList<>();
		for(int i = 0;i<cart.getProduct().size();i++)
		{
			Optional<Product> optionalProduct = productRepo.findById(cart.getProduct().get(i).getProductId());
			if(optionalProduct.isPresent())
			{
				product.add(optionalProduct.get());
				
			}
			
			
		}
		cart.setProduct(product);
		cartRepository.save(cart);
		
		return cart;
		
		
	}
	
	public void viewProductInCart(int id)
	{
		
	}

}
