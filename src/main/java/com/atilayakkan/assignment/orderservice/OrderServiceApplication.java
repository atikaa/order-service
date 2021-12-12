package com.atilayakkan.assignment.orderservice;

import com.atilayakkan.assignment.orderservice.entity.Order;
import com.atilayakkan.assignment.orderservice.repository.OrderRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceApplication.class);

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.debug("Initializing with default documents...");

        orderRepository.deleteAll();
        orderRepository.save(new Order(String.valueOf(new ObjectId()), "12345", "charles.morris@reqres.in", "Charles", "Morris"));
        orderRepository.save(new Order(String.valueOf(new ObjectId()), "16971", "emma.wong@reqres.in", "Emma", "Wong"));

    }
}
