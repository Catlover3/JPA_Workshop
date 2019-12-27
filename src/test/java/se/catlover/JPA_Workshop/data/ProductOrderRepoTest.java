package se.catlover.JPA_Workshop.data;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import se.catlover.JPA_Workshop.data.ProductOrderRepo;
import se.catlover.JPA_Workshop.entity.Customer;
import se.catlover.JPA_Workshop.entity.OrderItem;
import se.catlover.JPA_Workshop.entity.Product;
import se.catlover.JPA_Workshop.entity.ProductOrder;


@DataJpaTest
public class ProductOrderRepoTest {
	
	private ProductOrderRepo productOrderRepo;
	
	private ProductOrder productOrderTest;
	private Product productTest;
    private OrderItem orderItemTest;
    private Customer costumerTest;
    private LocalDate localDateTest;
    private ProductOrder productOrderTest2;
    private List<OrderItem> orderItemsListTest = new ArrayList<OrderItem>();
    private List<ProductOrder> productOrderListTest = new ArrayList<ProductOrder>();
    
    @Autowired 
    TestEntityManager em;
  
    
    @BeforeEach
    public void setUp() {
    	localDateTest = LocalDate.now();
    	//localDateTest.of(2019,12,19); alternativt sätt att lägga till localdate
    	productTest = new Product("Pear", 5);
    	costumerTest = new Customer("Anders", "Andersson", "Anders.andersson@mail.se");
    	
    	
    	orderItemTest = new OrderItem(10, productTest,productOrderTest);
    	orderItemsListTest.add(orderItemTest);
    	productOrderTest = new ProductOrder(localDateTest, orderItemsListTest, costumerTest);

    	em.persistAndFlush(productOrderTest);
    }
    
    @AfterEach
    public void closeResources() {
    	//productOrderListTest = null;
    }
    
    @Test
    public void Query_find_orderItems_by_productId() {
    	productOrderListTest = productOrderRepo.findByOrderItemsProductProductId(1);
    	assertEquals(productOrderTest, productOrderTest2);
    }
    
    @Test
    public void findByCustomerUserId() {
    	productOrderListTest = productOrderRepo.findByCustomerUserId(1);
    	assertEquals(productOrderTest, productOrderTest2);
    }
    //stringVariable.containns(String.valueOf(productOrder))
    
    @Test
    public void findByOrderItemsProductNameIgnoreCase() {
    	productOrderListTest = productOrderRepo.findByOrderItemsProductNameIgnoreCase("Pear");
    	assertEquals(1, productOrderListTest.size());
    	assertTrue(productOrderListTest.contains(productOrderTest));
    	
    }










} //End of class
