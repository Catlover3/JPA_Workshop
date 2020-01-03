	package se.catlover.JPA_Workshop.entity;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

import javassist.expr.NewArray;
import se.catlover.JPA_Workshop.entity.Customer;
import se.catlover.JPA_Workshop.entity.OrderItem;
import se.catlover.JPA_Workshop.entity.Product;
import se.catlover.JPA_Workshop.entity.ProductOrder;

	public class TestOrderItem {
		
		private Product productTest;
		private Product productTest2;
	    private OrderItem orderItemTest;
	    private OrderItem orderItemTest2;
	    private ProductOrder productOrderTest;
	    private Customer costumerTest;
	    private LocalDate localDate;
	    List<OrderItem> orderitemsListTest = new ArrayList<>();

	   @BeforeEach
	    void setUp() {
	    	localDate = LocalDate.parse("2019-12-19");
	        productTest = new Product("Pear", 7);
	        productTest2 = new Product("Apple", 12);
	        costumerTest = new Customer("Anders", "Andersson", "Anders.andersson@mail.se");
	        
	       
	        orderItemTest = new OrderItem(2, productTest);
	        orderItemTest2 = new OrderItem(2, productTest2);
	        orderitemsListTest.add(orderItemTest);
	        orderitemsListTest.add(orderItemTest2);
	        productOrderTest = new ProductOrder(localDate, orderitemsListTest, costumerTest);

	        //productOrderTest.addOrderItem(orderItemTest);
	        //productOrderTest.addOrderItem(orderItemTest2);
	    }
	    @Test
	    public void calculatePriceTest() {
	    	assertEquals(14, orderItemTest.calculatePrice());
	    	assertEquals(24, orderItemTest2.calculatePrice());
	    }
	    
	    @Test
	    public void testObject_successfully_created(){
	   	assertEquals(2, orderItemTest.getQuantity());
	    }

		@Test
		public void set_and_get_product(){
			orderItemTest.setProduct(productTest2);
			assertEquals(productTest2, orderItemTest.getProduct(productTest2));
			assertEquals(2, orderItemTest.getQuantity());
		}

	    @Test
	    public void doesListContainObject() {
	   	orderitemsListTest.contains(orderItemTest);
	    }


	    @Test
	    public void copyOf_testObject_equals_is_true(){
			OrderItem copy = new OrderItem(2, productTest);
	        assertTrue(copy.equals(orderItemTest));
	    }

		@Test
		public void copyOf_testObject_hashcode_is_true(){
			OrderItem copy = new OrderItem(2, productTest);
			assertEquals(copy.hashCode(), orderItemTest.hashCode());
		}

	    @Test
	    public void toString_contains_correct_information(){
	        String toString = orderItemTest.toString();
	        assertTrue(toString.contains("2"));
			assertTrue(toString.contains("Pear"));
			assertTrue(toString.contains("7"));
	    }
	    
	}//End of class
