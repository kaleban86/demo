package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderLineServiceTest {

    @Autowired
    OrderLineService orderLineService;

    @Test
    void findAll() {

        assertThat(orderLineService.findAll());
    }

    @Test
    void findById() {

       assertThat(orderLineService.findById(1L));
    }

    @Test
    void save() {


    }

    @Test
    void delete() {

       // assertThat(orderLineService.delete(1));
    }
}