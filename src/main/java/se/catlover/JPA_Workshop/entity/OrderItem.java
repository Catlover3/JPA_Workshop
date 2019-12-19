package se.catlover.JPA_Workshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderItemId;
	
	private int quantity;
	
	@ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
			fetch = FetchType.EAGER)
	private Product product;
	
	@ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
			fetch = FetchType.LAZY)
	private ProductOrder productOrder;
	
	
	
	
//	public OrderItem(int id, int quantity, Product product, ProductOrder productOrder) {
//		super();
//		this.orderItemId = id;
//		this.quantity = quantity;
//		this.product = product;
//		this.productOrder = productOrder;
//	}
	
	public OrderItem(int quantity, Product product, ProductOrder productOrder) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.productOrder = productOrder;
	}
	
	public double calculatePrice() {
		double totalPrice = this.product.getPrice() * this.quantity;
		return totalPrice;
	}
	
	public int getId() {
		return orderItemId;
	}
	public void setId(int id) {
		this.orderItemId = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductOrder getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(ProductOrder productOrder) {
		this.productOrder = productOrder;
	}

}
