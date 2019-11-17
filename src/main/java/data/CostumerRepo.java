package data;

import org.springframework.data.repository.CrudRepository;

import Entity.Costumer;

public interface CostumerRepo extends CrudRepository<Costumer, Integer> {
	
	public Costumer findByEmailContaining(String email);

}
