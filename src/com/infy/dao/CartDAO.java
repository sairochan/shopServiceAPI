package com.infy.dao;

import java.util.List;

import com.infy.model.Cart;
import com.infy.model.Product;

public interface CartDAO {
	public Integer addinto(Cart cart,Integer q);
	public Cart delete(Cart cart);
	public List<Product> getfinalcart(Cart cart);
	public Cart buy(String email);
}
