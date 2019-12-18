package entity;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import Entity.Costumer;
// TODO: Use list.contains kombinerat med assertTrue för att testa ifall listan hämtar rätt data
import Entity.OrderItem;
import Entity.Product;
import Entity.ProductOrder;
import data.ProductOrderRepo;

public class TestProductOrder {
	
	private ProductOrderRepo productOrderRepoTest;
	
	private ProductOrder productOrderTest;
	private Product productTest;
    private OrderItem orderItemTest;
    private Costumer costumerTest;
    private LocalDate localDateTest;
    private List<OrderItem> orderItemsListTest;
	
    @BeforeEach
	    void setUp() {
    	localDateTest = LocalDate.parse("2019-11-01");
    	productTest = new Product("Pear", 5);
    	costumerTest = new Costumer("Anders", "Andersson", "Anders.andersson@mail.se");
    	orderItemTest = new OrderItem(10, productTest,productOrderTest);
        orderItemsListTest.add(orderItemTest);
        productOrderTest = new ProductOrder(localDateTest, orderItemsListTest, costumerTest);
        productTest = new Product("Pear", 5);
        
    }

    @Test
    public void testLists(){

    
    	
//	    assertTrue(orderItemsListTest.contains(orderItemTest))
//		List <ProductOrder> findByProductIdIn(List<OrderItem> orderItems, int id);
//		List <ProductOrder> findByProductName(String name);
//		List <ProductOrder> findByCostumerId(int id);
	
    }
	
	
	
	
}
