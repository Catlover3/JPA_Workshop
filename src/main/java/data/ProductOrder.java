package data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/*
TODO: Change all methods to use "in" query correctly
 */
import Entity.OrderItem;

public interface ProductOrder extends CrudRepository<ProductOrder, Integer> {

	@Query("SELECT * from ProductOrder ORDER BY CreationDate DESC")
	List <ProductOrder> listAllProductOrdersByDate();
	
	@Query("SELECT * from ProductOrder WHERE costumer.id ?1 ORDER BY CreationDate DESC")
	List<ProductOrder> listAllProductOrdersByCostumerIdSortedByDate(int id);
	
	List <ProductOrder> findByProductIdIn(List<OrderItem> orderItems, int id);
	List <ProductOrder> findByProductName(String name);
	List <ProductOrder> findByCostumerId(int id);
	
}
