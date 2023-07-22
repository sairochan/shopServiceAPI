package com.infy.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import com.infy.model.Cart;
import com.infy.model.Product;
import com.infy.service.CartService;
import com.infy.service.CartServiceImpl;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="CartAPI")
public class CartAPI {
	
	private CartService cs;
	
	@RequestMapping(method=RequestMethod.POST, value="addinto")
	public ResponseEntity<Integer> addinto(@RequestBody Cart cart){

		ResponseEntity<Integer> res=null;
		cs = (CartServiceImpl) ContextFactory.getContext().getBean(CartServiceImpl.class);
		
		Integer sum= cs.addinto(cart, cart.getQuantity());
		
		if(sum==null) {
			return res=new ResponseEntity<>(sum, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(sum, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="getfinalcart")
	public ResponseEntity<List<Product>> getfinalcart(@RequestBody Cart cart){

		ResponseEntity<List<Product>> res=null;
		cs = (CartServiceImpl) ContextFactory.getContext().getBean(CartServiceImpl.class);
		
		List<Product> pr= cs.getfinalcart(cart);
		
		if(pr.isEmpty()) {
			return res=new ResponseEntity<>(pr, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="delete")
	public ResponseEntity<Cart> deleteP(@RequestBody Cart cart){
		System.out.println(cart.getProdid()+"API    "+cart.getEmailId());
		ResponseEntity<Cart> res=null;
		cs = (CartServiceImpl) ContextFactory.getContext().getBean(CartServiceImpl.class);
		Cart c= cs.delete(cart);
		if(c==null) {
			return res=new ResponseEntity<>(c, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="buy/{email}")
	public ResponseEntity<Cart> buy(@PathVariable String email){

		ResponseEntity<Cart> res=null;
		cs = (CartServiceImpl) ContextFactory.getContext().getBean(CartServiceImpl.class);
		
		Cart s = cs.buy(email+".com");
		
		if(s==null) {
			return res=new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	
}
