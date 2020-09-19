package com.example.demo.service;

import com.example.demo.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void findAll() {

        assertThat(orderService.findAll());
    }

    @Test
    void save() {

        assertThat(orderService.save(new Order("test","test","test")));
    }
}