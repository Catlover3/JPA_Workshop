package se.catlover.JPA_Workshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	private String name;
	private int price;

	
	public Product(int id, String name, int price) {
		super();
		this.productId = id;
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
	public int getProductId() {
		return productId;
	}

	public void setproductId(int id) {
		this.productId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}


}
