package com.example.OrderDeliverySystem.Modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	 
	private String Name;
	private double  Price;
	
	
	
	
	
	public Product() {
		
	}
	public Product(long id, String name, double price) {
		super();
		this.id = id;
		Name = name;
		Price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	
}
