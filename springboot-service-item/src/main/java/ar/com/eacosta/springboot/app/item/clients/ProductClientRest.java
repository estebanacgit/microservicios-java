package ar.com.eacosta.springboot.app.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ar.com.eacosta.springboot.app.item.models.Product;

@FeignClient(name = "servicie-products", url = "localhost:8001")
public interface ProductClientRest {
	
	@GetMapping("/list")
	public List<Product> list();
	
	@GetMapping("/list/{id}")
	public Product details(@PathVariable Long id);

}
