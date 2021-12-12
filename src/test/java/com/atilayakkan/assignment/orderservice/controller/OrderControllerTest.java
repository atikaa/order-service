package com.atilayakkan.assignment.orderservice.controller;

import com.atilayakkan.assignment.orderservice.dto.CreateOrderDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createOrder_whenValidRequest_thenReturn201() throws Exception {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID("12345");
        createOrderDTO.setEmail("george.bluth@reqres.in");

        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(createOrderDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void createOrder_whenNullProductID_thenReturn400() throws Exception {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID(null);
        createOrderDTO.setEmail("george.bluth@reqres.in");

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(createOrderDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createOrder_whenNullEmail_thenReturn400() throws Exception {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID("12345");
        createOrderDTO.setEmail(null);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(createOrderDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createOrder_whenEmptyEmail_thenReturn400() throws Exception {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID("12345");
        createOrderDTO.setEmail("");

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(createOrderDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createOrder_whenInvalidEmail_thenReturn400() throws Exception {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setProductID("12345");
        createOrderDTO.setEmail("atilayakkan.com");

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(createOrderDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllOrders_whenValidRequest_thenReturn200() throws Exception {
        mockMvc.perform(get("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}