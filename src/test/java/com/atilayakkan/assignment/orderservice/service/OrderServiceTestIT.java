package com.atilayakkan.assignment.orderservice.service;

import com.atilayakkan.assignment.orderservice.dto.CreateOrderDTO;
import com.atilayakkan.assignment.orderservice.exception.InvalidUserException;
import com.atilayakkan.assignment.orderservice.exception.OrderAlreadyExistsException;
import com.atilayakkan.assignment.orderservice.model.ApiResponsePayload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class OrderServiceTestIT {

    @Autowired
    OrderService orderService;

    @Test
    void createOrder_whenGivenValidRequest_thenReturnSuccess() {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID("12345");
        createOrderDTO.setEmail("tracey.ramos@reqres.in");

        ApiResponsePayload<Object> order = orderService.createOrder(createOrderDTO);

        assertThat(order).isNotNull();
        assertThat(order.getPayload()).isNotNull();
    }

    @Test
    void createOrder_whenInvalidEmail_thenThrowInvalidUserException() {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID("12345");
        createOrderDTO.setEmail("atilayakkan@live.com");

        assertThrows(InvalidUserException.class, () -> orderService.createOrder(createOrderDTO));
    }

    @Test
    void createOrder_whenOrderAlreadyExists_thenThrowOrderAlreadyExistsException() {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID("12345");
        createOrderDTO.setEmail("charles.morris@reqres.in");

        assertThrows(OrderAlreadyExistsException.class, () -> orderService.createOrder(createOrderDTO));
    }
}