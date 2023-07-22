package com.infy.service;

import java.util.List;

import com.infy.model.Cart;
import com.infy.model.Product;
import com.infy.model.users;

public interface CartService {
	public Integer addinto(Cart cart,Integer q);
	public Cart delete(Cart cart);
	public List<Product> getfinalcart(Cart cart);
	public Cart buy( String email);
}
