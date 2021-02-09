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

import com.example.OrderDeliverySystem.Modal.Order;
import com.example.OrderDeliverySystem.Repository.OrderRepository;
import com.example.OrderDeliverySystem.exception.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/orders")
@Api(value = "order", description = "Operations pertaining to order in order Management System")
public class OrderController {
 
	
 @Autowired
 private OrderRepository _orderRepository;
 @ApiOperation(value = "View a list of available orders", response = List.class)
 @ApiResponses(value = {
     @ApiResponse(code = 200, message = "Successfully retrieved list"),
     @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
     @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
     @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
 })
 @RequestMapping(value ="/getAllOrders", method = RequestMethod.GET)
 public java.util.List<Order> getAllOrders() {
	return _orderRepository.findAll();
}
 
 @ApiOperation(value = "Get an order by Id")
 @RequestMapping("/{id}")
 public Order getOrderById(@PathVariable(value ="id") long OrderId ) {
	
	return this._orderRepository.findById(OrderId)
			.orElseThrow(() -> new ResourceNotFoundException("Order not found with id :" + OrderId));
}
 @ApiOperation(value = "Add an order")
 @RequestMapping(value = "/createOrder" , method = RequestMethod.POST)	
 public Order Create(@RequestBody Order order) {
	return this._orderRepository.save(order);
}

 @ApiOperation(value = "update an order")
 @RequestMapping(value = "/updateOrder{Id}", method = RequestMethod.PUT)  
 public Order UpdateOrder(@PathVariable(value ="id") long OrderId, Order order) {
	  Order orderData =  this._orderRepository.findById(OrderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id :" + OrderId));
	  orderData.setCustomerId(order.getCustomerId());
	  orderData.setOrderDate(order.getOrderDate());
		 return this._orderRepository.save(orderData);
	
}
 @ApiOperation(value = "Delete an order")
 @DeleteMapping("/{Id}") 
 public ResponseEntity<Order> Delete(@PathVariable("Id") long OrderId) {
	 Order OrderData = this._orderRepository.findById(OrderId)
			 .orElseThrow(() -> new ResourceNotFoundException("Order not found with id :" + OrderId));
	this._orderRepository.delete(OrderData);
	return  ResponseEntity.ok().build();
}
 
}
