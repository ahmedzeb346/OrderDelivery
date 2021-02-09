package com.example.OrderDeliverySystem.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.OrderDeliverySystem.Modal.Product;
import com.example.OrderDeliverySystem.Repository.ProductRepository;
import com.example.OrderDeliverySystem.exception.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/Product")
@Api(value = "Product", description = "Operations pertaining to Product in Product")
public class ProductController {
@Autowired
private ProductRepository _productRepository;
@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})

@RequestMapping(value="/getAllProduct", method = RequestMethod.GET)
public java.util.List<Product> getAllProduct() {
	return this._productRepository.findAll();
}

@ApiOperation(value = "Get an Product by Id")
@RequestMapping("/{id}")
public Product getCustomerById(@PathVariable(value="id") long ProductId) {
	return this._productRepository.findById(ProductId)
			.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + ProductId));
}
@ApiOperation(value = "Add an Product")
@RequestMapping(value = "/createProduct" , method = RequestMethod.POST)	
public Product CreateProduct(@RequestBody Product product) {
	return this._productRepository.save(product);
}

@ApiOperation(value = "update an product")
@RequestMapping(value = "/updateCustomer{Id}", method = RequestMethod.PUT)  
public Product UpdateProduct(@PathVariable(value ="id") long ProductId, Product product) {
	Product productData =  this._productRepository.findById(ProductId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + ProductId));
	productData.setName(product.getName());
	productData.setPrice(product.getPrice());
		 return this._productRepository.save(productData);
	
}

@ApiOperation(value = "Delete an product")
@DeleteMapping("/{Id}") 
public ResponseEntity<Product> Delete(@PathVariable("Id") long ProductId) {
	Product productData  = this._productRepository.findById(ProductId)
			 .orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + ProductId));
	this._productRepository.delete(productData);
	return  ResponseEntity.ok().build();
}

}
