package com.atilayakkan.assignment.orderservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private String responseCode;
    private String responseMessage;
    private String responseDescription;
    private List<String> errorMessages;

    public ApiResponse() {
    }

    public ApiResponse(String responseCode, String responseMessage, String responseDescription, List<String> errorMessages) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseDescription = responseDescription;
        this.errorMessages = errorMessages;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", responseDescription='" + responseDescription + '\'' +
                ", errorMessages=" + errorMessages +
                '}';
    }

    public static final class ApiResponseBuilder {
        String responseCode;
        String responseMessage;
        String responseDescription;
        List<String> errorMessages;

        public ApiResponseBuilder() {}

        public static ApiResponse.ApiResponseBuilder anApiResponse() {
            return new ApiResponse.ApiResponseBuilder();
        }

        public ApiResponse.ApiResponseBuilder withResponseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public ApiResponse.ApiResponseBuilder withResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
            return this;
        }

        public ApiResponse.ApiResponseBuilder withResponseDescription(String responseDescription) {
            this.responseDescription = responseDescription;
            return this;
        }

        public ApiResponse.ApiResponseBuilder withErrorMessages(List<String> errorMessages) {
            this.errorMessages = errorMessages;
            return this;
        }

        public ApiResponse build() {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.responseCode = this.responseCode;
            apiResponse.responseMessage = this.responseMessage;
            apiResponse.responseDescription = this.responseDescription;
            apiResponse.errorMessages = this.errorMessages;
            return apiResponse;
        }
    }
}
