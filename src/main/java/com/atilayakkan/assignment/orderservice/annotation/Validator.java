package com.atilayakkan.assignment.orderservice.annotation;

import com.atilayakkan.assignment.orderservice.model.ServiceResponse;
import com.atilayakkan.assignment.orderservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validator implements ConstraintValidator<ValidateResponse, ResponseEntity<ServiceResponse<User>>> {
    @Override
    public boolean isValid(ResponseEntity<ServiceResponse<User>> serviceResponseResponseEntity, ConstraintValidatorContext constraintValidatorContext) {
        return validateResponse(serviceResponseResponseEntity);
    }

    public boolean validateResponse(ResponseEntity<ServiceResponse<User>> response) {
        return !(null == response || !response.getStatusCode().equals(HttpStatus.OK) || null == response.getBody() || null == response.getBody().getData());
    }
}
