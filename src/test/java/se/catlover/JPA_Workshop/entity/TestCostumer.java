package se.catlover.JPA_Workshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCostumer {
    private Product productTest;
    private Product productTest2;
    private OrderItem orderItemTest;
    private OrderItem orderItemTest2;
    private ProductOrder productOrderTest;
    private Customer customerTest;
    private LocalDate localDate;
    List<OrderItem> orderitemsListTest = new ArrayList<>();

    @BeforeEach
    void setUp() {
        localDate = LocalDate.parse("2019-12-19");
        productTest = new Product("Pear", 7);
        productTest2 = new Product("Apple", 12);
        customerTest = new Customer("Anders", "Andersson", "Anders.andersson@mail.se");


        orderItemTest = new OrderItem(2, productTest);
        orderItemTest2 = new OrderItem(2, productTest2);
        orderitemsListTest.add(orderItemTest);
        orderitemsListTest.add(orderItemTest2);
        productOrderTest = new ProductOrder(localDate, orderitemsListTest, customerTest);

        //productOrderTest.addOrderItem(orderItemTest);
        //productOrderTest.addOrderItem(orderItemTest2);
    }

    @Test
    public void get_firstname(){
        assertEquals("Anders", customerTest.getFirstName());
    }

    @Test
    public void set_and_get_firstname(){
        customerTest.setFirstName("Lars");
        assertEquals("Lars", customerTest.getFirstName());
    }

    @Test
    public void testObject_successfully_created(){
        assertEquals("Anders", customerTest.getFirstName());
    }


    @Test
    public void copyOf_testObject_equals_is_true(){
        Customer copy = new Customer("Anders", "Andersson", "Anders.andersson@mail.se");
        assertTrue(copy.equals(customerTest));
    }

    @Test
    public void copyOf_testObject_hashcode_is_true(){
        Customer copy = new Customer("Anders", "Andersson", "Anders.andersson@mail.se");
        assertEquals(copy.hashCode(), customerTest.hashCode());
    }

    @Test
    public void toString_contains_correct_information(){
        String toString = customerTest.toString();
        assertTrue(toString.contains("Anders"));
        assertTrue(toString.contains("Andersson"));
        assertTrue(toString.contains("Anders.andersson@mail.se"));
    }



}//End of class
