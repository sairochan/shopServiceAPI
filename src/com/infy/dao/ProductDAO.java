package com.infy.dao;

import java.util.List;

import com.infy.model.Product;

public interface ProductDAO {
	public Product addProduct(Product product);
	public Product deleteProduct(Product product);
	public Product updateProduct(Product product);
	public Product showProduct(Product product);
	public List<Product> showProductName(Product product);
	public List<Product> search(String s);
	public List<Product> showByCategory(Product product);
}
