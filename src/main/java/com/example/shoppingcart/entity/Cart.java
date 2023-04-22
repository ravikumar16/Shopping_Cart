package com.example.shoppingcart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	
	@Id
	private int cartId;
	
	@OneToMany
	private List<Product> product;

}
