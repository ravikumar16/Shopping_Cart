package com.example.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Users;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.UsersRepository;


@Service
public class UsersService {
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired 
	CartRepository cartRepository;
	
	
	public void saveUser(Users user)
	{
//		Story story = book.getStory();
//        story.setBook(book);
//        book = bookRepository.save(book);
//        return book;
        
        Cart cart = user.getCart();
        cartRepository.save(cart);
        
		userRepository.save(user);
	}
	
	

}
