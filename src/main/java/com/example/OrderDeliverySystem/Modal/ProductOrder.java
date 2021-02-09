package com.example.OrderDeliverySystem.Modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductOrders")
public class ProductOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private long Quantity;
	private long ProductId;
	private long OrderId;	
	//private Product Product;
	//private Order Order;
	
	
	
	
	public ProductOrder() {
	
	}

	public ProductOrder(long id, long quantity, long productId, long orderId) {
		super();
		this.id = id;
		Quantity = quantity;
		ProductId = productId;
		OrderId = orderId;
		
	}

	@Override
	public String toString() {
		return "ProductOrder [id=" + id + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	
	public long getProductId() {
		return ProductId;
	}
	public void setProductId(long productId) {
		ProductId = productId;
	}
	public long getQuantity() {
		return Quantity;
	}
	public void setQuantity(long quantity) {
		Quantity = quantity;
	}
	
	
	
	
	
}
