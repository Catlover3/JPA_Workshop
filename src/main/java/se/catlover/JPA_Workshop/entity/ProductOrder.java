package se.catlover.JPA_Workshop.entity;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class ProductOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productOrderId;
	
	@Column(name = "CreationDate")
	private LocalDate orderDateTime;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval= true)
	private List <OrderItem> orderItems;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
	
//	public ProductOrder(int productOrderId, LocalDate orderDateTime, List<OrderItem> orderItems, Customer customer) {
//		super();
//		this.productOrderId = productOrderId;
//		this.orderDateTime = orderDateTime;
//		this.orderItems = orderItems;
//		this.customer = customer;
//	}
	
	public ProductOrder(LocalDate orderDateTime, List<OrderItem> orderItems, Customer customer) {
		super();
		this.orderDateTime = orderDateTime;
		this.orderItems = orderItems;
		this.customer = customer;
	}

	public double calculateTotalPrice() {
		double totalSum = 0;
				
		for (OrderItem item : orderItems ) {
			totalSum += item.calculatePrice();
		 }
		
		return totalSum;
	}

	
	
	public void removeLastOrderItem() {
		orderItems.remove(orderItems.size()- 1); 
	}
	
    public void removeOrderItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
    }
    
    public void addOrderItem(OrderItem orderItem) {
    	orderItems.add(orderItem);
    }


	public int getProductOrderId() {
		return productOrderId;
	}


	public void setProductOrderId(int productOrderId) {
		this.productOrderId = productOrderId;
	}


	public LocalDate getOrderDateTime() {
		return orderDateTime;
	}


	public void setOrderDateTime(LocalDate orderDateTime) {
		this.orderDateTime = orderDateTime;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		customer = customer;
	}
    


    
	


}
