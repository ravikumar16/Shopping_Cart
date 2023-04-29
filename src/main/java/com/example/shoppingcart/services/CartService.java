package com.example.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	
	public Cart addProductToCart(Cart cart)
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
	
	public Cart viewProductInCart(int id)
	{
		Optional<Cart> cart = cartRepository.findById(id);
		if(cart.isPresent())
		{
			return cart.get();
			
		}
		
		return null;
		
	}

	public Cart removeProductFromCart(int cartId,int ProductId)
	{
		Optional<Cart> optionalcart = cartRepository.findById(cartId);
		List<Product> productList = null;
		if(optionalcart.isPresent())
		{
			productList = optionalcart.get().getProduct();
			productList = productList.stream().
			filter(
					product -> product.getProductId()!= ProductId)
			.collect(Collectors.toList());
			
		}
		Cart cart =  optionalcart.get();
		cart.setProduct(productList);
		
		cartRepository.save(cart);
		return cart;
	}

	public Cart removeAllProductFromCart(int cartId ) {
		// TODO Auto-generated method stub
		Optional<Cart> optionalcart = cartRepository.findById(cartId);
		List<Product> productList = null;
		if(optionalcart.isPresent())
		{
			productList = optionalcart.get().getProduct();
			productList.clear();
		}
		Cart cart =  optionalcart.get();
		cart.setProduct(productList);
		
		cartRepository.save(cart);
		return cart;
	}
}
