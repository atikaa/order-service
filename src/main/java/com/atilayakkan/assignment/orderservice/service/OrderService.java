package com.atilayakkan.assignment.orderservice.service;

import com.atilayakkan.assignment.orderservice.client.UserClient;
import com.atilayakkan.assignment.orderservice.dto.CreateOrderDTO;
import com.atilayakkan.assignment.orderservice.entity.Order;
import com.atilayakkan.assignment.orderservice.exception.InvalidUserException;
import com.atilayakkan.assignment.orderservice.exception.OrderAlreadyExistsException;
import com.atilayakkan.assignment.orderservice.model.ApiResponsePayload;
import com.atilayakkan.assignment.orderservice.model.ServiceResponse;
import com.atilayakkan.assignment.orderservice.model.User;
import com.atilayakkan.assignment.orderservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.atilayakkan.assignment.orderservice.constant.OrderConstants.ApiResponseConstants.*;
import static com.atilayakkan.assignment.orderservice.constant.OrderConstants.LogConstants.ORDER_CREATED;
import static com.atilayakkan.assignment.orderservice.util.Generator.generateOrder;

@Service
public class OrderService implements IOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    @Override
    public ApiResponsePayload<Object> createOrder(CreateOrderDTO createOrderDTO) {
        ResponseEntity<ServiceResponse<User>> userServiceResponse = userClient.getUsers(0, Integer.MAX_VALUE);

        User user = checkUserByEmail(userServiceResponse.getBody().getData(), createOrderDTO.getEmail());
        checkPreviousOrder(createOrderDTO.getProductID(), createOrderDTO.getEmail());

        Order createdOrder = orderRepository.save(generateOrder(createOrderDTO.getProductID(), user));
        LOG.debug(ORDER_CREATED, createdOrder.get_id());

        return new ApiResponsePayload<>(API_RESPONSE_SUCCESS_CODE, API_RESPONSE_SUCCESS_MESSAGE, API_RESPONSE_SUCCESS_DESCRIPTION, null, createdOrder.get_id());
    }

    @Override
    public ApiResponsePayload<Object> getAllOrders(Pageable pageable) {
        Page<Order> orders = orderRepository.findAll(pageable);

        return new ApiResponsePayload<>(API_RESPONSE_SUCCESS_CODE, API_RESPONSE_SUCCESS_MESSAGE, API_RESPONSE_SUCCESS_DESCRIPTION, null, orders);
    }

    private User checkUserByEmail(List<User> userList, String email) {
        return userList.stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst()
                .orElseThrow(InvalidUserException::new);
    }

    private void checkPreviousOrder(String productID, String email) {
        Order previousOrder = orderRepository.findByProductIDAndEmail(productID, email);
        if (null != previousOrder) {
            throw new OrderAlreadyExistsException();
        }
    }
}
