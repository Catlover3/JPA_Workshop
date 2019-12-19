package se.catlover.JPA_Workshop.data;

import org.springframework.data.repository.CrudRepository;

import se.catlover.JPA_Workshop.entity.Costumer;

public interface CostumerRepo extends CrudRepository<Costumer, Integer> {
	
	public Costumer findByEmailContaining(String email);

}
