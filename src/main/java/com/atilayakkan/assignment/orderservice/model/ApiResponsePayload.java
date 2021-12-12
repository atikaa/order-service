package com.atilayakkan.assignment.orderservice.model;

import java.util.List;

public class ApiResponsePayload<T> extends ApiResponse {

    private T payload;

    public ApiResponsePayload() {
    }

    public ApiResponsePayload(String responseCode, String responseMessage, String responseDescription, List<String> errorMessages, T payload) {
        super(responseCode, responseMessage, responseDescription, errorMessages);
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ApiResponsePayload{" +
                "payload=" + payload +
                '}';
    }
}
