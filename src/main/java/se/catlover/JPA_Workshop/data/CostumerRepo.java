package se.catlover.JPA_Workshop.data;

import org.springframework.data.repository.CrudRepository;

import se.catlover.JPA_Workshop.entity.Customer;

public interface CostumerRepo extends CrudRepository<Customer, Integer> {
	
	public Customer findByEmailContaining(String email);

}
