package entity;

import java.util.List;
// TODO: Use list.contains kombinerat med assertTrue för att testa ifall listan hämtar rätt data
import Entity.OrderItem;
import data.ProductOrder;

public class TestProductOrder {
	List <ProductOrder> findByProductIdIn(List<OrderItem> orderItems, int id);
	List <ProductOrder> findByProductName(String name);
	List <ProductOrder> findByCostumerId(int id);
}
