package ar.com.eacosta.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ar.com.eacosta.springboot.app.item.clients.ProductClientRest;
import ar.com.eacosta.springboot.app.item.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductClientRest productClientRestFeign;

	@Override
	public List<Item> findAll() {
		return productClientRestFeign.list().stream().map(prod -> new Item(prod, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(productClientRestFeign.details(id), quantity);
	}

}
