package se.catlover.JPA_Workshop.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import se.catlover.JPA_Workshop.data.ProductOrderRepo;
import se.catlover.JPA_Workshop.entity.Costumer;
import se.catlover.JPA_Workshop.entity.OrderItem;
import se.catlover.JPA_Workshop.entity.Product;
import se.catlover.JPA_Workshop.entity.ProductOrder;


@DataJpaTest
public class ProductOrderRepoTest {
	
	private ProductOrderRepo productOrderRepoTest;
	
	private ProductOrder productOrderTest;
	private Product productTest;
    private OrderItem orderItemTest;
    private Costumer costumerTest;
    private LocalDate localDateTest;
    private List<OrderItem> orderItemsListTest;
    private List <ProductOrder>productOrderListTest;
    private ProductOrder productOrderTest2;
    
    @Autowired 
    TestEntityManager em;
  
    
    @BeforeEach
    public void setUp() {
    	localDateTest = LocalDate.now();
    	productTest = new Product("Pear", 5);
    	costumerTest = new Costumer("Anders", "Andersson", "Anders.andersson@mail.se");
    	orderItemTest = new OrderItem(10, productTest,productOrderTest);
    	orderItemsListTest.add(orderItemTest);
    	productOrderTest = new ProductOrder(localDateTest, orderItemsListTest, costumerTest);

    	em.persistAndFlush(productOrderTest);
    }
    
    
    @Test
    public void testQueryKeywords() {
    	ProductOrder productOrderTest2 = productOrderRepoTest.findByOrderItemsProductId(1);
    	assertEquals(productOrderTest, productOrderTest2);
    }
    
    @Test
    public void findByCostumerUserId() {
    	productOrderTest2 = productOrderRepoTest.findByCostumerUserId(1);
    	assertEquals(productOrderTest, productOrderTest2);
    }
    
    @Test
    public void findByOrderItemsProductNameIgnoreCase() {
    	productOrderListTest = productOrderRepoTest.findByOrderItemsProductNameIgnoreCase("pear");
    	assertEquals(1, productOrderListTest.size());
    	assertEquals(productOrderTest, productOrderListTest.get(1));
    }










} //End of class
