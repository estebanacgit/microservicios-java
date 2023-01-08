package ar.com.eacosta.springboot.app.products.repository;

import org.springframework.data.repository.CrudRepository;

import ar.com.eacosta.springboot.app.products.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
