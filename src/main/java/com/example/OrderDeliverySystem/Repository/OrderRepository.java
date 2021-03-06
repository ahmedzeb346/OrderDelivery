package com.example.OrderDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderDeliverySystem.Modal.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>  {

}
