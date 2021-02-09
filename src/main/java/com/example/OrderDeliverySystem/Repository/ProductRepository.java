package com.example.OrderDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderDeliverySystem.Modal.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

}
