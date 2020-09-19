package com.example.demo.service;

import com.example.demo.models.Goods;
import com.example.demo.models.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;
    @Test
    void findAll() throws Exception {

        assertThat(goodsService.findAll());
    }

    @Test
    void findById() throws Exception {


        assertThat(goodsService.findById(2L));


    }

    @Test
    void save() throws Exception{

        BigDecimal  price = BigDecimal.valueOf(3);
        assertThat(goodsService.save(new Goods("rr", price)));


    }

//    @Test
//    void delete(Goods goods) throws Exception {
//
//
//
//
//    }
}