package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.CartDAO;
import com.infy.entity.ProductEntity;
import com.infy.model.Cart;
import com.infy.model.Product;
import com.infy.model.users;

@Service("cartServiceImpl")
@Transactional(readOnly=true)
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO cartDAO;
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Integer addinto(Cart cart,Integer q){
		Integer total;
		Product prod=new Product();
		if(cart==null || q==null || q==0 || q<0  ) {
			return null;
		}
		Integer sum= cartDAO.addinto(cart, q);
		return sum;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public List<Product> getfinalcart(Cart cart){
	if(cart==null){
		return null;
	}
	List<Product> pr=cartDAO.getfinalcart(cart);
		if(!pr.isEmpty()){
			return pr;	
		}
	return null;
	}
	
	@Transactional(readOnly=false)
	public Cart delete(Cart cart){
		if(cart==null) {
			return null;
		}
		Cart c=new Cart();
		c=cartDAO.delete(cart);
		return c;
	}
	
	@Transactional(readOnly=false)
	public Cart buy( String email){
		if(email==null) {
			return null;
		}
		
		Cart c=cartDAO.buy(email);
		return c;
	}
}
