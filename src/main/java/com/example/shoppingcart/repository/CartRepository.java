package com.example.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingcart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
