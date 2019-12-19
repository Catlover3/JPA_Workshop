package se.catlover.JPA_Workshop.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import se.catlover.JPA_Workshop.data.ProductOrderRepo;
import se.catlover.JPA_Workshop.entity.Costumer;
import se.catlover.JPA_Workshop.entity.OrderItem;
import se.catlover.JPA_Workshop.entity.Product;
import se.catlover.JPA_Workshop.entity.ProductOrder;

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
	    assertTrue(orderItemsListTest.contains(orderItemTest));
	
    }
	
	
	
	
}
