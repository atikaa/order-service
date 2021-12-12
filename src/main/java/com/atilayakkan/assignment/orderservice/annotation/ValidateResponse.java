package com.atilayakkan.assignment.orderservice.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Validator.class)
@Documented
public @interface ValidateResponse {
    String message() default "Invalid response";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
