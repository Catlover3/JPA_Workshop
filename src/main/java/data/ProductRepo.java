package data;

import org.springframework.data.repository.CrudRepository;

import Entity.Product;

public interface ProductRepo extends CrudRepository <Product, Integer>{
	
	
}
