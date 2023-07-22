package com.infy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.ProductDAO;
import com.infy.model.Product;

@Service("productServiceImpl")
@Transactional(readOnly=true)
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Product addProduct(Product product) {
		System.out.println(product.getProdid());
	
		Product prod=new Product();
		prod=productDAO.addProduct(product);
		return prod;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Product deleteProduct(Product product)
	{
		if(product==null) {
			return null;
		}
		Product prod=new Product();
		prod=productDAO.deleteProduct(product);
		return prod;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Product updateProduct(Product product){
		if(product==null) {
			return null;
		}
		Product prod=new Product();
		prod=productDAO.updateProduct(product);
		return prod;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public List<Product> showProduct(Product product)
	{
		List<Product> pr=new ArrayList<>();
		Product prod=new Product();
		if(product.getProdid()!=null){
		prod=productDAO.showProduct(product);
		pr.add(prod);
		return pr;
				}
		else if(product.getProdname()!=null){
			pr=productDAO.showProductName(product);
			return pr;
		}
		return null;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public List<Product> search(String s)
	{
		List<Product> pr=new ArrayList<>();
				
		 
			pr=productDAO.search(s);
			if(pr.isEmpty()){
				return null;
			}
			return pr;
		
		
	}
	
	//29th April 2019 Mano Get by category
		@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
		public List<Product> showByCategory(Product product){
			List<Product> pr=new ArrayList<>();
			Product prod=new Product();
			if(product.getCategory()!=null){
				pr=productDAO.showByCategory(product);
				return pr;
			}
			else {
				return null;
			}
		}
}
