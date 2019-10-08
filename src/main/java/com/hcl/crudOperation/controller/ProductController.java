package com.hcl.crudOperation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.crudOperation.model.Product;
import com.hcl.crudOperation.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<>((productService.createProduct(product)), HttpStatus.CREATED);
	}

	/*
	 * @PostMapping("/createProduct") public Product createProducts(@RequestBody
	 * Product product) { return productService.createProduct(product); }
	 */

	@GetMapping("/select/{id}")
	public ResponseEntity<Product> get(@PathVariable("id") Long productId) {
		return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.ACCEPTED);
	}

	/*
	 * @GetMapping("/selectProduct/{id}") public Product
	 * getProduct(@PathVariable("id") Long productId) { return
	 * productService.getProduct(productId); }
	 */

	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/getAllProduct") public List<Product> getAllProduct() { return
	 * productService.getAllProduct(); }
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product Delete Success..", HttpStatus.OK);
	}

}
