package com.atilayakkan.assignment.orderservice.api;

import com.atilayakkan.assignment.orderservice.dto.CreateOrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Tag(name = "Order Service")
@RequestMapping(path = "api/orders")
public interface OrderServiceApi {

    @Operation(operationId = "createOrder", summary = "REST API to create new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "201, Created.", content = @Content(schema = @Schema(implementation = com.atilayakkan.assignment.orderservice.model.ApiResponse.class))),
            @ApiResponse(responseCode = "400", description = "400, Bad Request.", content = @Content(schema = @Schema(implementation = com.atilayakkan.assignment.orderservice.model.ApiResponse.class))),
    })
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> createOrder(@Valid @RequestBody CreateOrderDTO createOrderDTO);

    @Operation(operationId = "getAllOrders", summary = "REST API to get all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "200, OK.", content = @Content(schema = @Schema(implementation = com.atilayakkan.assignment.orderservice.model.ApiResponse.class))),
            @ApiResponse(responseCode = "400", description = "400, Bad Request.", content = @Content(schema = @Schema(implementation = com.atilayakkan.assignment.orderservice.model.ApiResponse.class)))
    })
    @GetMapping
    ResponseEntity<Object> getAllOrders(@PageableDefault(page = 0, size = Integer.MAX_VALUE) @Nullable Pageable pageable);
}
