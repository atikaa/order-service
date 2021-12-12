package com.atilayakkan.assignment.orderservice.controller;

import com.atilayakkan.assignment.orderservice.api.OrderServiceApi;
import com.atilayakkan.assignment.orderservice.dto.CreateOrderDTO;
import com.atilayakkan.assignment.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderServiceApi {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<Object> createOrder(CreateOrderDTO createOrderDTO) {
        return new ResponseEntity<>(orderService.createOrder(createOrderDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllOrders(Pageable pageable) {
        return new ResponseEntity<>(orderService.getAllOrders(pageable), HttpStatus.OK);
    }
}
