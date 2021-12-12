package com.atilayakkan.assignment.orderservice.client;

import com.atilayakkan.assignment.orderservice.annotation.ValidateResponse;
import com.atilayakkan.assignment.orderservice.model.ServiceResponse;
import com.atilayakkan.assignment.orderservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "userClient", url = "${client.userService.url}")
@Validated
public interface UserClient {

    @ValidateResponse
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<ServiceResponse<User>> getUsers(@RequestParam(name = "page", required = false) Integer page,
                                                   @RequestParam(name = "per_page", required = false) Integer perPage);

}
