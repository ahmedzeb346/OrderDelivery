package com.example.OrderDeliverySystem.Modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	 
	private String FirstName; 
	
	private String LastName; 

	private String Phone;

	
	
	
	public Customer() {
		
	}

	public Customer(long id, String firstName, String lastName, String phone) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Phone = phone;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	 
}
