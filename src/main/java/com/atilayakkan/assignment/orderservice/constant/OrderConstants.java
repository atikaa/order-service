package com.atilayakkan.assignment.orderservice.constant;

public class OrderConstants {

    private OrderConstants() {
    }

    public static class ApiResponseConstants {
        private ApiResponseConstants() {
        }

        public static final String API_RESPONSE_SUCCESS_CODE = "0";
        public static final String API_RESPONSE_SUCCESS_MESSAGE = "SUCCESS";
        public static final String API_RESPONSE_SUCCESS_DESCRIPTION = "Operation successful";
        public static final String API_RESPONSE_FAIL_CODE = "-1";
        public static final String API_RESPONSE_FAIL_MESSAGE = "FAIL";
        public static final String API_RESPONSE_FAIL_DESCRIPTION = "An exception occurred";
    }

    public static class LogConstants {
        private LogConstants() {
        }

        public static final String ORDER_CREATED = "Order is created with id: {}";
    }

    public static class ApiErrorConstants {
        private ApiErrorConstants() {}

        public static final String FEIGN_CLIENT_EXCEPTION = "Feign client exception";
        public static final String INVALID_RESPONSE_EXCEPTION = "Invalid response";
        public static final String MONGODB_EXCEPTION = "MongoDB exception";
        public static final String INVALID_USER_EXCEPTION = "No such user found with provided email";
        public static final String ORDER_ALREADY_EXISTS_EXCEPTION = "An order already exists with provided productID and email";
    }
}
