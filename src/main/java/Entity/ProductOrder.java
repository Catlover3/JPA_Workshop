package Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@OneToMany(orphanRemoval= true)
	private List <OrderItem> orderItems;
	
	@ManyToOne
	private Costumer Customer;
	
	
	public ProductOrder(int productOrderId, LocalDate orderDateTime, List<OrderItem> orderItems, Costumer customer) {
		super();
		this.productOrderId = productOrderId;
		this.orderDateTime = orderDateTime;
		this.orderItems = orderItems;
		Customer = customer;
	}
	
	public ProductOrder(LocalDate orderDateTime, List<OrderItem> orderItems, Costumer customer) {
		super();
		this.orderDateTime = orderDateTime;
		this.orderItems = orderItems;
		Customer = customer;
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


	public Costumer getCustomer() {
		return Customer;
	}


	public void setCustomer(Costumer customer) {
		Customer = customer;
	}
    


    
	


}
