package ar.com.eacosta.springboot.app.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.eacosta.springboot.app.products.entity.Product;
import ar.com.eacosta.springboot.app.products.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public List<Product> list(){
		return productService.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Product details(@PathVariable Long id) {
		return productService.findById(id);
	}
	

}
