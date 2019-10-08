package com.hcl.crudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.crudOperation.model.Product;
import com.hcl.crudOperation.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public Product createProduct(Product product) {
	Product p=productRepository.save(product);
	if(p!=null)
		return p;
	else
		return null;
	}

	@Override
	public Product getProduct(Long productId) {
		Product p=productRepository.findById(productId).get();
		if(p.getpId()>0)
			return p;
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product deleteProduct(Long productId) {
	Product p=	productRepository.findById(productId).get();
	/*if(p!=null)
	{
	productRepository.delete(p);
	return "product Delete Success";
	}
	else
		return "Product Not There";
	}*/
    productRepository.delete(p);
	 return p;
	}

}
