package se.catlover.JPA_Workshop.data;

import org.springframework.data.repository.CrudRepository;

import se.catlover.JPA_Workshop.entity.Product;

public interface ProductRepo extends CrudRepository <Product, Integer>{
	
	
}
