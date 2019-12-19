package se.catlover.JPA_Workshop.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import se.catlover.JPA_Workshop.entity.OrderItem;
import se.catlover.JPA_Workshop.entity.ProductOrder;

public interface ProductOrderRepo extends CrudRepository<ProductOrder, Integer> {

	@Query("SELECT o from ProductOrder o ORDER BY o.orderDateTime DESC")
	List <ProductOrder> listAllProductOrdersByDate();
	
	@Query(value = "SELECT * from ProductOrder WHERE id = ?1 ORDER BY CreationDate DESC", nativeQuery = true)
	List<ProductOrder> listAllProductOrdersByCostumerIdSortedByDate(int id);

	List<ProductOrder> findByOrderItemsProductProductId(int id);
	
	List<ProductOrder> findByOrderItemsProductNameIgnoreCase(String name);
	
	List<ProductOrder> findByCustomerUserId(int id);
}
