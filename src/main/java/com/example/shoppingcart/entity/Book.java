package com.example.shoppingcart.entity;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
	
	private String genre;
	private String author;
	private String publications;
	

}
