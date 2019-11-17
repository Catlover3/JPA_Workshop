	package entity;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

import Entity.Costumer;
import Entity.OrderItem;
import Entity.Product;
import Entity.ProductOrder;

	public class TestOrderItem {
		
		private Product testProduct;
	    private OrderItem testOrderItem;
	    private ProductOrder testProductOrder;
	    private Costumer testCostumer;
	    private LocalDate localDate;
	    private List<OrderItem> orderitems;

	    @BeforeEach
	    void setUp() {
	    	localDate = LocalDate.now();
	        testProduct = new Product("Pear", 5);
	        testCostumer = new Costumer("Anders", "Andersson", "Anders.andersson@mail.se");
	        testOrderItem = new OrderItem(10, testProduct,testProductOrder);
	        orderitems.add(testOrderItem);
	        testProductOrder = new ProductOrder(localDate, orderitems, testCostumer);
	    }

	    @Test
	    public void testObject_successfully_created(){
	        assertEquals(0, testOrderItem.getQuantity());
	    }

	    @Test
	    public void copyOf_testObject_equals_is_true(){
	    	OrderItem copy = new OrderItem(10, testProduct,testProductOrder);
	        assertTrue(copy.equals(testOrderItem));
	        assertEquals(copy.hashCode(), testOrderItem.hashCode());
	    }

	    @Test
	    public void toString_contains_correct_information(){
	        String toString = testOrderItem.toString();
	        assertTrue(toString.contains("10"));
	    }
	    
	}//End of class
