package com.infy.api;

import java.util.ArrayList;
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
import com.infy.service.CartServiceImpl;
import com.infy.service.ProductServiceImpl;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="ProductAPI")
public class ProductAPI {

	private ProductServiceImpl as;
	
	@RequestMapping(method=RequestMethod.GET, value="search/{str}")
	public ResponseEntity<List<Product>> search( @PathVariable("str") String s){
		System.out.println(s);
		ResponseEntity<List<Product>> res=null;
		List<Product> serres=new ArrayList<Product>();
		as = (ProductServiceImpl) ContextFactory.getContext().getBean(ProductServiceImpl.class);
		
		serres= as.search(s);
		
		if(serres.isEmpty()) {
			return res=new ResponseEntity<>(serres, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(serres, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="addProducts")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//		System.out.println(product+" from api *");
		product.setImg("assets/"+product.getImg().substring(12));
		System.out.println(product.getImg());
		ResponseEntity<Product> res=null;
		Product prod=new Product();
		as =  ContextFactory.getContext().getBean(ProductServiceImpl.class);
//		System.out.println(product.getProdid()+" from api");
		prod=as.addProduct(product);
		
		if(prod==null) {
			return res=new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(prod, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="deleteProducts")
	public ResponseEntity<Product> deleteProduct(@RequestBody Product product)
	{
		ResponseEntity<Product> res=null;
		Product prod=new Product();
		as =  ContextFactory.getContext().getBean(ProductServiceImpl.class);
//		System.out.println(product.getProdid()+" from api");
		prod=as.deleteProduct(product);
		
		if(prod==null) {
			return res=new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(prod, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="updateProducts")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		ResponseEntity<Product> res=null;
		Product prod=new Product();
		as =  ContextFactory.getContext().getBean(ProductServiceImpl.class);
		prod=as.updateProduct(product);
		
		if(prod==null) {
			return res=new ResponseEntity<>(prod, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(prod, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="showProducts")
	public ResponseEntity<List<Product>> showProduct(@RequestBody Product product)
	{
		List<Product> pr=new ArrayList<>();
		ResponseEntity<List<Product>> res=null;
		Product prod=new Product();
		as =  ContextFactory.getContext().getBean(ProductServiceImpl.class);
		pr=as.showProduct(product);
		if(pr.isEmpty()) {
			return res=new ResponseEntity<>(pr, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="showByCategory")
	public ResponseEntity<List<Product>> showByCategory(@RequestBody Product product)
	{
		List<Product> pr=new ArrayList<>();
		ResponseEntity<List<Product>> res=null;
		Product prod=new Product();
		as =  ContextFactory.getContext().getBean(ProductServiceImpl.class);
		pr=as.showByCategory(product);
		if(pr.isEmpty()) {
			return res=new ResponseEntity<>(pr, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(pr, HttpStatus.OK);
	}
	
	
	
}
