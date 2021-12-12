package com.atilayakkan.assignment.orderservice.util;

import com.atilayakkan.assignment.orderservice.entity.Order;
import com.atilayakkan.assignment.orderservice.model.ApiResponse;
import com.atilayakkan.assignment.orderservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.atilayakkan.assignment.orderservice.constant.OrderConstants.ApiResponseConstants.*;

public class Generator {

    private Generator() {
    }

    public static Order generateOrder(String productID, User user) {
        Order order = new Order();
        order.setProductID(productID);
        order.setEmail(user.getEmail());
        order.setFirstName(user.getFirstName());
        order.setLastName(user.getLastName());

        return order;
    }

    public static ResponseEntity<ApiResponse> generateApiErrorResponse(List<String> errorMessage, HttpStatus httpStatus, String... paramsWithOrderResponseCodeMessageDescription) {
        ApiResponse apiResponse = ApiResponse.ApiResponseBuilder.anApiResponse()
                .withResponseCode(paramsWithOrderResponseCodeMessageDescription.length > 0 ? paramsWithOrderResponseCodeMessageDescription[0] : API_RESPONSE_FAIL_CODE)
                .withResponseMessage(paramsWithOrderResponseCodeMessageDescription.length > 1 ? paramsWithOrderResponseCodeMessageDescription[1] : API_RESPONSE_FAIL_MESSAGE)
                .withResponseDescription(paramsWithOrderResponseCodeMessageDescription.length > 2 ? paramsWithOrderResponseCodeMessageDescription[2] : API_RESPONSE_FAIL_DESCRIPTION)
                .withErrorMessages(errorMessage)
                .build();

        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
