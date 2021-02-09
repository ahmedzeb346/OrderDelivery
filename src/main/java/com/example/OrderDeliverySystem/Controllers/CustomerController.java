package com.example.OrderDeliverySystem.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.OrderDeliverySystem.Modal.Customer;
import com.example.OrderDeliverySystem.Repository.CustomerRepository;
import com.example.OrderDeliverySystem.exception.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/customer")
@Api(value = "Customer", description = "Operations pertaining to Customer in Customer Management System")
public class CustomerController {
@Autowired
 private CustomerRepository _customerRepository;
@ApiOperation(value = "View a list of available Customers", response = List.class)
@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved list"),
    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})

@RequestMapping(value="/getAllCustomer", method = RequestMethod.GET)
public java.util.List<Customer> getAllCustomer() {
	return this._customerRepository.findAll();
}

@ApiOperation(value = "Get an Customer by Id")
@RequestMapping("/{id}")
public Customer getCustomerById(@PathVariable(value="id") long CustomerId) {
	return this._customerRepository.findById(CustomerId)
			.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id :" + CustomerId));
}

@ApiOperation(value = "Add an customer")
@RequestMapping(value = "/createCustomer" , method = RequestMethod.POST)	
public Customer Create(@RequestBody Customer customer) {
	return this._customerRepository.save(customer);
}

@ApiOperation(value = "update an customer")
@RequestMapping(value = "/updateCustomer{Id}", method = RequestMethod.PUT)  
public Customer UpdateCustomer(@PathVariable(value ="id") long CustomerId, Customer customer) {
	Customer customerData =  this._customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id :" + CustomerId));
	customerData.setFirstName(customer.getFirstName());
	customerData.setLastName(customer.getLastName());
	customerData.setPhone(customer.getPhone());
		 return this._customerRepository.save(customerData);
	
}

@ApiOperation(value = "Delete an customer")
@DeleteMapping("/{Id}") 
public ResponseEntity<Customer> Delete(@PathVariable("Id") long CustomerId) {
	Customer customerData  = this._customerRepository.findById(CustomerId)
			 .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id :" + CustomerId));
	this._customerRepository.delete(customerData);
	return  ResponseEntity.ok().build();
}


}
