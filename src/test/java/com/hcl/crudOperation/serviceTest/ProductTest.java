package com.hcl.crudOperation.serviceTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.hcl.crudOperation.model.Product;
import com.hcl.crudOperation.repository.ProductRepository;
import com.hcl.crudOperation.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@Test
	public void getAllUserTest() {
		List<Product> products = new ArrayList<Product>();
		Product p = new Product();
		p.setpId(1L);
		p.setDate(new Date());
		p.setpName("Shankar");
		p.setPrice(5000);
		p.setQuantity(20);

		Product p1 = new Product();
		p1.setpId(2L);
		p1.setDate(new Date());
		p1.setpName("Raja");
		p1.setPrice(6000);
		p1.setQuantity(10);

		products.add(p);
		products.add(p1);

		when(productRepository.findAll()).thenReturn(products);
		assertEquals(2, productService.getAllProduct().size());
	}

	@Test
	public void createProductTest() {
		Product p = new Product();
		p.setpId(1L);
		p.setDate(new Date());
		p.setpName("Shankar");
		p.setPrice(5000);
		p.setQuantity(20);
		
		when(productRepository.save(p)).thenReturn(p);
		assertEquals(p, productService.createProduct(p));
	}

	@Test
	public void deleteProductTest() {

		Product p = new Product();
		p.setpId(1L);
		p.setDate(new Date());
		p.setpName("Shankar");
		p.setPrice(5000);
		p.setQuantity(20);

		productRepository.delete(p);
		verify(productRepository, times(1)).delete(p);

	}

}
