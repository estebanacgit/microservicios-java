package ar.com.eacosta.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.com.eacosta.springboot.app.item.models.Item;
import ar.com.eacosta.springboot.app.item.models.Product;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clientRest;

	@Override
	public List<Item> findAll() {
		
		List<Product> products = Arrays.asList(clientRest.getForObject("http://localhost:8001/list", Product[].class));
		
		return products.stream().map(prod -> new Item(prod, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Product product = clientRest.getForObject("http://localhost:8001/list/{id}", Product.class, pathVariables);
		
		return new Item(product, quantity);
	}

}
