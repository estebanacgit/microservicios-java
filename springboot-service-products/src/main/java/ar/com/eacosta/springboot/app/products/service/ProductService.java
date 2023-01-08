package ar.com.eacosta.springboot.app.products.service;

import java.util.List;

import ar.com.eacosta.springboot.app.products.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(Long id);

}
