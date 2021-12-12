package com.atilayakkan.assignment.orderservice.exception;

import com.atilayakkan.assignment.orderservice.model.ApiResponse;
import com.mongodb.MongoException;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static com.atilayakkan.assignment.orderservice.constant.OrderConstants.ApiErrorConstants.*;
import static com.atilayakkan.assignment.orderservice.constant.OrderConstants.ApiResponseConstants.API_RESPONSE_FAIL_CODE;
import static com.atilayakkan.assignment.orderservice.constant.OrderConstants.ApiResponseConstants.API_RESPONSE_FAIL_MESSAGE;
import static com.atilayakkan.assignment.orderservice.util.Generator.generateApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = FeignException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse> handleFeignException(FeignException exception) {
        LOG.error(exception.getMessage(), exception);
        return generateApiErrorResponse(null, HttpStatus.INTERNAL_SERVER_ERROR, API_RESPONSE_FAIL_CODE, API_RESPONSE_FAIL_MESSAGE, FEIGN_CLIENT_EXCEPTION);
    }

    @ExceptionHandler(value = InvalidResponseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse> handleInvalidResponseException(InvalidResponseException exception) {
        LOG.error(exception.getMessage(), exception);
        return generateApiErrorResponse(null, HttpStatus.INTERNAL_SERVER_ERROR, API_RESPONSE_FAIL_CODE, API_RESPONSE_FAIL_MESSAGE, INVALID_RESPONSE_EXCEPTION);
    }

    @ExceptionHandler(value = MongoException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse> handleMongoException(MongoException exception) {
        LOG.error(exception.getMessage(), exception);
        return generateApiErrorResponse(null, HttpStatus.INTERNAL_SERVER_ERROR, API_RESPONSE_FAIL_CODE, API_RESPONSE_FAIL_MESSAGE, MONGODB_EXCEPTION);
    }

    @ExceptionHandler(value = InvalidUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> handleInvalidUser(InvalidUserException exception) {
        LOG.error(exception.getMessage(), exception);
        return generateApiErrorResponse(null, HttpStatus.BAD_REQUEST, API_RESPONSE_FAIL_CODE, API_RESPONSE_FAIL_MESSAGE, INVALID_USER_EXCEPTION);
    }

    @ExceptionHandler(value = OrderAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> handleOrderAlreadyExists(OrderAlreadyExistsException exception) {
        LOG.error(exception.getMessage(), exception);
        return generateApiErrorResponse(null, HttpStatus.BAD_REQUEST, API_RESPONSE_FAIL_CODE, API_RESPONSE_FAIL_MESSAGE, ORDER_ALREADY_EXISTS_EXCEPTION);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> handleMethodArgumentsNotValid(MethodArgumentNotValidException exception) {
        LOG.error(exception.getMessage(), exception);
        List<String> errors = exception.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return generateApiErrorResponse(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> handleConstraintViolationException(ConstraintViolationException exception) {
        LOG.error(exception.getMessage(), exception);
        List<String> errors = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return generateApiErrorResponse(errors, HttpStatus.BAD_REQUEST);
    }
}
