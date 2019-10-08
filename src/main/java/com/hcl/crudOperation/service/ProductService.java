package com.hcl.crudOperation.service;

import java.util.List;

import com.hcl.crudOperation.model.Product;

public interface ProductService {
	public Product createProduct(Product product);
	public Product getProduct(Long productId);
	public List<Product> getAllProduct();
	public Product deleteProduct(Long productId);
	
	
	
}
