package com.infy.service;

import java.util.List;

import com.infy.model.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public Product deleteProduct(Product product);
	public Product updateProduct(Product product);
	public List<Product> showProduct(Product product);
	public List<Product> search(String s);
	public List<Product> showByCategory(Product product);

}
