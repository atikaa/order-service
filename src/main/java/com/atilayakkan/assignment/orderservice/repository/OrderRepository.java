package com.atilayakkan.assignment.orderservice.repository;

import com.atilayakkan.assignment.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByProductIDAndEmail(String productID, String email);
}
