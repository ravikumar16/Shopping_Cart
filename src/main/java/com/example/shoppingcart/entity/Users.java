package com.example.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Users {
	
	
	@Id
	private int userId;
	
	@OneToOne
	private Cart cart;
	

}
