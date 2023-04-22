package com.example.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingcart.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
