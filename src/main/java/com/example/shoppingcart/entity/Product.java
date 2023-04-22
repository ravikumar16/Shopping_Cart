package com.example.shoppingcart.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private Integer price;
	
	

}
