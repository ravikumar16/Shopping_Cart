package com.example.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.entity.Book;
import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.Users;
import com.example.shoppingcart.services.CartService;
import com.example.shoppingcart.services.ProductService;
import com.example.shoppingcart.services.UsersService;

@RestController
public class Controller {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UsersService userservice;
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/cart/add")
	public Cart addproductToCart(@RequestBody Cart cart )
	{
		
		return cartService.addProductTocart(cart);
		
		
	}
	
	
	@PostMapping("/user/new")
	public String addUser(@RequestBody Users user) 
	{
		userservice.saveUser(user);
		
		return "saved" + user;
		
	}
	
	@PostMapping("/product/add/")
	public String addProduct()
	{
		Book book =new Book();
		
		book.setProductName("The");
		book.setAuthor("RAVI");
		book.setPublications("Vidyasagar");
		book.setGenre("1st");
		book.setPrice(50);
		System.out.print(book);
		return productService.saveProduct(book);	
		
	}
	
	@GetMapping("/search/product/")
	public List<Product> searchProduct(
			    @RequestParam("id") Optional<Integer> id,
			    @RequestParam("name") Optional<String> name,
			    @RequestParam("Type") Optional<String> Type)
	{
		List<Product> productlist = new ArrayList<>();
		if(id.isPresent())
		{
			
			productlist.add(productService.searchProductById(id.get()));
		}
		
		if(name.isPresent())
		{
			productlist = productService.searchProductByName(name.get());
		}
		
		if(Type.isPresent())
		{
			productlist = productService.searchProductByCategory(Type.get());
		}
		
		return productlist;
					
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
		return  "HI";
	}
	
	
	

}
