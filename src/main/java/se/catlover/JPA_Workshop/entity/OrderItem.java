package se.catlover.JPA_Workshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

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

	public OrderItem(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
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

	public Product getProduct(Product product) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderItem orderItem = (OrderItem) o;
		return orderItemId == orderItem.orderItemId &&
				quantity == orderItem.quantity &&
				Objects.equals(product, orderItem.product) &&
				Objects.equals(productOrder, orderItem.productOrder);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderItemId, quantity, product, productOrder);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("OrderItem{");
		sb.append("orderItemId=").append(orderItemId);
		sb.append(", quantity=").append(quantity);
		sb.append(", product=").append(product);
		sb.append(", productOrder=").append(productOrder);
		sb.append('}');
		return sb.toString();
	}
} //End of class
