package com.atilayakkan.assignment.orderservice.service;

import com.atilayakkan.assignment.orderservice.dto.CreateOrderDTO;
import com.atilayakkan.assignment.orderservice.model.ApiResponsePayload;
import org.springframework.data.domain.Pageable;

public interface IOrderService {

    ApiResponsePayload<Object> createOrder(CreateOrderDTO createOrderDTO);

    ApiResponsePayload<Object> getAllOrders(Pageable pageable);
}
