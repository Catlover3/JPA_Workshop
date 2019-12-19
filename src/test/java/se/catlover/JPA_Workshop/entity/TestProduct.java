package se.catlover.JPA_Workshop.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.catlover.JPA_Workshop.entity.Product;

public class TestProduct {
	

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product("Pear", 5);
    }

    @Test
    public void testObject_successfully_created(){
        assertEquals(0, testProduct.getProductId());
        assertEquals("Pear", testProduct.getName());
        assertEquals(5, testProduct.getPrice());

    }

    @Test
    public void copyOf_testObject_equals_is_true(){
        Product copy = new Product("Pear", 5);
        assertTrue(copy.equals(testProduct));
        assertEquals(copy.hashCode(), testProduct.hashCode());
    }

    @Test
    public void toString_contains_correct_information(){
        String toString = testProduct.toString();
        assertTrue(toString.contains("Pear"));
		assertTrue(toString.contains("5"));
    }
    
}//End of class