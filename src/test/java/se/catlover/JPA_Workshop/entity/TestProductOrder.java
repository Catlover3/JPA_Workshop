package se.catlover.JPA_Workshop.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import javassist.expr.NewArray;
import se.catlover.JPA_Workshop.data.ProductOrderRepo;
import se.catlover.JPA_Workshop.entity.Customer;
import se.catlover.JPA_Workshop.entity.OrderItem;
import se.catlover.JPA_Workshop.entity.Product;
import se.catlover.JPA_Workshop.entity.ProductOrder;

public class TestProductOrder {
	
	private ProductOrderRepo productOrderRepoTest;
	
	private ProductOrder productOrderTest;
	private Product productTest;
    private OrderItem orderItemTest;
    private Customer costumerTest;
    private LocalDate localDateTest;
    private List<OrderItem> orderItemsListTest = new ArrayList<OrderItem>();
	
    @BeforeEach
	    void setUp() {
    	//localDateTest = LocalDate.parse("2019-11-01"); annat sätt att lägga till datumet
        //Exemplet nedanför känns bättre
        localDateTest.of(2019,12,19);
    	productTest = new Product("Pear", 5);
    	costumerTest = new Customer("Anders", "Andersson", "Anders.andersson@mail.se");
    	orderItemTest = new OrderItem(10, productTest,productOrderTest);
        orderItemsListTest.add(orderItemTest);
        productOrderTest = new ProductOrder(localDateTest, orderItemsListTest, costumerTest);


        
    }

    @Test
    public void OrderItemsListTest_contains_right_orderitem(){
	    assertTrue(orderItemsListTest.contains(orderItemTest));
	
    }

    @Test
    public void get_and_set_orderDateTime(){
        LocalDate localDateTest2 = null;
        localDateTest2.of(2019,12,19);

        productOrderTest.setOrderDateTime(localDateTest2);
        assertEquals(localDateTest, productOrderTest.getOrderDateTime());
    }

    @Test
    public void calcTotalPrice(){
        assertEquals(50, productOrderTest.calculateTotalPrice() );
    }

	
	
}
