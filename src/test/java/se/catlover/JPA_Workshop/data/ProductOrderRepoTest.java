package se.catlover.JPA_Workshop.data;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.data.jpa.repository.Query;
import se.catlover.JPA_Workshop.entity.Customer;
import se.catlover.JPA_Workshop.entity.OrderItem;
import se.catlover.JPA_Workshop.entity.Product;
import se.catlover.JPA_Workshop.entity.ProductOrder;


@DataJpaTest
public class ProductOrderRepoTest {
    @Autowired
	private ProductOrderRepo productOrderRepo;

	private ProductOrder productOrderTest;
	private Product productTest;
    private OrderItem orderItemTest;
    private Customer costumerTest;
    private LocalDate localDateTest;
    private ProductOrder productOrderTest2;
    private List<OrderItem> orderItemsListTest = new ArrayList<>();
    private List<ProductOrder> productOrderListTest = new ArrayList<>();

    @Autowired
    TestEntityManager em;

    @BeforeEach
    public void setUp() {
    	localDateTest = LocalDate.now();
    	localDateTest.of(2019,12,19); //alternativt sätt att lägga till localdate
    	productTest = new Product("Pear", 5);
    	costumerTest = new Customer("Anders", "Andersson", "Anders.andersson@mail.se");


    	orderItemTest = new OrderItem(10, productTest);
    	orderItemsListTest.add(orderItemTest);
    	productOrderTest = new ProductOrder(localDateTest, orderItemsListTest, costumerTest);

    	em.persistAndFlush(productOrderTest);
    }

   @Test
    public void Query_find_Productorders_by_productId() {
    	productOrderListTest = productOrderRepo.findByOrderItems_Product_ProductId(1);
    	assertTrue(productOrderListTest.contains(productOrderTest));
    }

    @Test
    public void findByCustomerUserId() {
    	productOrderListTest = productOrderRepo.findByCustomerUserId(1);
    	assertEquals(productOrderTest, productOrderTest2);
    }
    //stringVariable.contains(String.valueOf(productOrder))

    @Test
    public void findByOrderItemsProductNameIgnoreCase() {
    	productOrderListTest = productOrderRepo.findByOrderItemsProductNameIgnoreCase("pear");
    	assertEquals(1, productOrderListTest.size());
    	assertTrue(productOrderListTest.contains(productOrderTest));
    }

    @Test
    public void test_jpa_querylistAllProductOrdersByDate() {
        productOrderListTest = productOrderRepo.listAllProductOrdersByDate();
        assertTrue(productOrderListTest.contains(productOrderTest));
    }

    @Test
    public void test_jpa_querylistAllProductOrdersByCostumerIdSortedByDate() {
        productOrderListTest = productOrderRepo.listAllProductOrdersByDate();
        assertTrue(productOrderListTest.contains(productOrderTest));
    }






} //End of class
