package com.example.OrderDeliverySystem.Modal;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date OrderDate; 
	private long CustomerId; 

	//private Customer Customer;

	
	
	public Order() {
		
	}

	

	public Order(long id, Date orderDate, long customerId) {
		super();
		this.id = id;
		OrderDate = orderDate;
		CustomerId = customerId;
	}



	@Override
	public String toString() {
		return "Order [OrderDate=" + OrderDate + "]";
	}

	

	public long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	} 

      
}
