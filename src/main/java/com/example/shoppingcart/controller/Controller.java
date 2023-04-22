package com.example.shoppingcart.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@PostMapping("/cart/add/{product_id}")
	public String addproductToCart(@PathVariable int product_id)
	{
		return "addProductToCart is working fine" + product_id;
	}
	
	@DeleteMapping("/cart/remove/{product_id}")
	public String removeProductFromCart(@PathVariable int product_id)
	{
		return "remove product From Cart is working fine" + product_id;
	}
	
	@DeleteMapping("/cart/remove/all")
	public String removeAllProductFromCart()
	{
		return "remove All Product From Cart is working fine";
		
	}
	
	@PutMapping("/cart/updatecart/{product_id}")
	public String updateCart(@PathVariable int product_id)
	{
		return "Update All Product From Cart is working fine" + product_id 	 ;
		
	}
	
	@GetMapping("/cart/view")
	public String viewCart()
	{
		return  "viewCart is working fine";
	}
	
	
	

}
